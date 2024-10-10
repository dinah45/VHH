package com.example.vhh.ui.chat

import com.example.vhh.ui.data.db.models.User
import com.example.vhh.ui.theme.AppColor
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.gestures.AnchoredDraggableState
import androidx.compose.foundation.gestures.DraggableAnchors
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.anchoredDraggable
import androidx.compose.foundation.gestures.animateTo
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.vhh.ui.networkModels.Message
import com.example.vhh.ui.utill.formatDate
import kotlinx.coroutines.delay
import timber.log.Timber
import kotlin.math.roundToInt

@OptIn(ExperimentalFoundationApi::class, ExperimentalGlideComposeApi::class)
@Composable
fun ChatItem(
    message: Message,
    viewModel: ChatViewModel,
    user: User?,
    canSelect: Boolean,
    selected: Boolean,
    onSelect: (Message) -> Unit,
    onReply: () -> Unit
) {
    var item by remember { mutableStateOf(message) }
    val config = LocalConfiguration.current
    val width = config.screenWidthDp.dp
    val density = LocalDensity.current
    val interactionSource = remember { MutableInteractionSource() }
    val dragableState = remember {
        AnchoredDraggableState(
            // 2
            initialValue = DragAnchors.Start,
            // 3
            positionalThreshold = { distance: Float -> distance * 0.5f },
            // 4
            velocityThreshold = { with(density) { 100.dp.toPx() } },
            // 5
            animationSpec = tween()
        ).apply {
            // 6
            updateAnchors(
                // 7
                DraggableAnchors {
                    DragAnchors.Start at 0f
                    DragAnchors.End at if (item.userId != user?.id) width.value * 0.8f else -width.value * 0.8f
                }
            )
        }
    }

    //listen to drag end event
    LaunchedEffect(interactionSource) {
        interactionSource.interactions.collect { interaction ->
            when (interaction) {
                is DragInteraction.Stop -> {
                    onReply.invoke()
                    delay(100)
                    //animate back to start
                    dragableState.animateTo(
                        DragAnchors.Start,
                        velocity = with(density) { 110.dp.toPx() },
                    )
                }
            }
        }
    }
//    LaunchedEffect(key1 = user) {
//        if (user != null && message.readBy.contains(user.id).not()) {
//            viewModel.readChat(user.id, message.id)
//        }
//    }
//    if (user != null) {
//        DisposableEffect(Unit) {
//            viewModel.socket.on("updateMessage-${message.id}") {
//                Timber.d("updateMessage: $it")
//                val newMsg = it[0].toString().toObject(Message::class.java)
//                item = newMsg
//            }
//            onDispose {
//                viewModel.socket.off("updateMessage-${message.id}")
//            }
//        }
//    }

    Row(
        Modifier
            .combinedClickable(
                onLongClick = { if (item.isDeleted.not()) onSelect.invoke(item) },
                onClick = { if (canSelect && item.isDeleted.not()) onSelect.invoke(item) }
            )
            .padding(vertical = 4.dp)
            .background(if (selected) Color.Yellow.copy(alpha = 0.3f) else Color.Transparent)
            .fillMaxWidth(),
        horizontalArrangement = if (item.type == "EVENT") Arrangement.Center
        else if (item.userId != user?.id) Arrangement.Start else Arrangement.End
    ) {
        Timber.d("chat item: ${item.type}")
        if (item.type == "EVENT") {
            Card(
                Modifier
                    .padding(horizontal = 16.dp, vertical = 4.dp),
                shape = CardDefaults.elevatedShape,
                colors = CardDefaults.cardColors(
                    containerColor = AppColor,
                ),
//                elevation = CardDefaults.cardElevation(
//                    defaultElevation = 8.dp
//                )
            ) {
                Text(
                    text = item.text,
                    color = Color.LightGray,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(10.dp),
                )
            }
        } else if (item.isDeleted) {
            Card(
                Modifier
                    .padding(horizontal = 16.dp, vertical = 4.dp),
                shape = CardDefaults.elevatedShape,
                colors = CardDefaults.cardColors(
                    containerColor = if (item.userId == user?.id) AppColor else AppColor.copy(0.5f),
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 8.dp
                )
            ) {
                Text(
                    text = "Message Deleted",
                    color = Color.LightGray,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(10.dp),
                )
            }
        } else Card(
            Modifier
                .anchoredDraggable(
                    state = dragableState,
                    orientation = Orientation.Horizontal,
                    interactionSource = interactionSource,
                )
                .padding(horizontal = 16.dp, vertical = 4.dp)
                .offset {
                    IntOffset(
                        // 2
                        x = dragableState
                            .requireOffset()
                            .roundToInt(),
                        y = 0,
                    )
                },
            shape = CardDefaults.elevatedShape,
            colors = CardDefaults.cardColors(
                containerColor = if (item.userId == user?.id) AppColor else AppColor.copy(0.5f),
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            )
        ) {
            Column(Modifier.widthIn(min = 150.dp, max = width * 0.7f)) {
                if (item.replyTo != null) {
                    Card(
                        Modifier
                            .heightIn(min = 43.dp, max = 80.dp),
                        shape = RoundedCornerShape(0.dp, 16.dp, 16.dp, 0.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.Black.copy(alpha = 0.5f),
                        ),
                    ) {
                        Row(
                            Modifier.widthIn(min = 150.dp, max = width * 0.7f),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column(Modifier.weight(1f)) {
                                Spacer(modifier = Modifier.height(10.dp))
                                Text(
                                    text = item.replyTo!!.user.firstName,
                                    color = Color.Yellow,
                                    style = MaterialTheme.typography.bodyLarge,
//                                fontWeight = FontWeight.Bold,
                                    modifier = Modifier
                                        .padding(horizontal = 10.dp),
                                    fontSize = 14.sp
                                )
                                Spacer(modifier = Modifier.height(2.dp))
                                Text(
                                    text = item.replyTo!!.text,
                                    maxLines = 2,
                                    color = Color.LightGray,
                                    style = MaterialTheme.typography.bodyLarge,
                                    modifier = Modifier.padding(horizontal = 10.dp),
                                    overflow = TextOverflow.Ellipsis,
                                )
                                Spacer(modifier = Modifier.height(15.dp))
                            }

                            if (item.replyTo!!.media != null) {
                                Box(
                                    modifier = Modifier
                                        .width(60.dp)
                                        .fillMaxHeight()
                                ) {
                                    GlideImage(
                                        model = item.replyTo!!.media,
                                        contentDescription = "chat image",
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .background(AppColor.copy(alpha = 0.5f)),
                                        contentScale = ContentScale.Crop
                                    )
                                }
                            }

                        }
                    }
                }
                if (item.media != null) {
                    //chat image
                    Card(
                        Modifier
                            .offset(y = (-12).dp),
                        shape = CardDefaults.elevatedShape,
                        colors = CardDefaults.cardColors(
                            containerColor = Color.Transparent,
                        ),
                    ) {
                        GlideImage(
                            model = item.media,
                            contentDescription = "chat image",
                            modifier = Modifier
                                .height(width * 0.5f)
                                .background(AppColor.copy(alpha = 0.5f)),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
                Spacer(modifier = Modifier.height(6.dp))
                // Chat item content
                Text(
                    text = item.text,
                    color = Color.LightGray,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(horizontal = 10.dp),
                )
                Spacer(modifier = Modifier.padding(2.dp))
                // Chat item timestamp
                Text(
                    text = item.createdAt.formatDate(),
                    color = Color.LightGray,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(horizontal = 10.dp),
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.padding(8.dp))
            }
        }
    }
}

enum class DragAnchors {
    Start,
    End,
}
