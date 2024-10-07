package com.example.vhh.ui.chat

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import androidx.core.net.toUri
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.vhh.R
import com.example.vhh.ui.theme.AppColor
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material.shimmer
import com.google.accompanist.placeholder.placeholder
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.result.NavResult
import com.ramcosta.composedestinations.result.ResultRecipient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel
import timber.log.Timber
import java.util.Locale

@OptIn(ExperimentalGlideComposeApi::class)
@Destination
@Composable
fun Chat(
                    id: String,
                    conversation: Conversation? = null,
  idIsProposal: Boolean = false,
                    shopId: String? = null,
                    fileRecipient: ResultRecipient<ChooseMediaDestination, String>,
                    awardResult: ResultRecipient<AwardContractDestination, Proposal>,
                    congratsResult: ResultRecipient<ReceiveContractDestination, String>,
                    navigator: DestinationsNavigator
                ) {
                    val viewModel: ChatViewModel = koinViewModel()
                    val user = viewModel.user.observeAsState().value
                    val clipboardManager = LocalClipboardManager.current
                    val context = LocalContext.current
                    var files by remember {
                        mutableStateOf(emptyList<MediaModel>())
                    }
                    var conver by remember {
                        mutableStateOf(conversation)
                    }
                    var chatRes by remember {
                        mutableStateOf<MessageResponse?>(null)
                    }
                    val chats = remember {
                        mutableStateListOf<Message>()
                    }
                    var proposal by remember {
                        mutableStateOf<Proposal?>(null)
                    }
                    val chatState = rememberLazyListState()
                    val scope = rememberCoroutineScope()
                    LaunchedEffect(user) {
                        if (user != null) {
                            if (id == "support") {
                                viewModel.getSupport(user.id)
                            } else {
                                viewModel.getConvr(id, user.id)
                            }
                        }
                    }

                    LaunchedEffect(conver) {
                        if (conver != null) {
                            viewModel.getMessages(conver!!.id)

                            if (conver?.proposalId != null) {
                                viewModel.getProposal(conver!!.proposalId!!).addOnSuccessListener {
                                    proposal = it
                                }.addOnFailureListener {
                                    Toaster(
                                        context,
                                        it.localizedMessage ?: "Something went wrong: proposal",
                                        R.drawable.logo
                                    )
                                }
                            }
                        }
                    }
                    LaunchedEffect(key1 = chatRes) {
                        chats.addAll(chatRes?.data?.filterNot { res ->
                            chats.any { it.id == res.id }
                        } ?: emptyList())
                    }
                    if (user != null) {
                        DisposableEffect(Unit) {
                            viewModel.socket.on("support-${user.id}") {
                                Timber.d("Support: $it")
                                val newConv = it[0].toString().toObject(Conversation::class.java)
                                conver = newConv
                            }
                            viewModel.socket.on("convr-${user.id}") {
                                Timber.d("convr: $it")
                                val newConv = it[0].toString().toObject(Conversation::class.java)
                                conver = newConv
                            }

                            viewModel.socket.on("awarded") {
                                Timber.d("awarded: $it")
                                val updatedProposal = it[0].toString().toObject(Proposal::class.java)
                                proposal = updatedProposal
                                //navigate on main thread
                                if (updatedProposal.job.userId != user.id) {
                                    scope.launch(Dispatchers.Main) {
                                        navigator.navigate(ReceiveContractDestination)
                                    }
                                }
                            }
                            onDispose {
                                viewModel.socket.off("support-${user.id}")
                                viewModel.socket.off("convr-${user.id}")
                                viewModel.socket.off("awarded")
                            }
                        }
                    }

                    if (conver != null) {
                        DisposableEffect(Unit) {
                            viewModel.socket.on("messages-${conver!!.id}") {
                                val newChats = it[0].toString().toObject(MessageResponse::class.java)
                                Timber.d("Messages: $newChats")
                                chatRes = newChats
                            }
                            viewModel.socket.on("newMessage-${conver!!.id}") {
                                Timber.d("Messages: $it")
                                val newChats = it[0].toString().toObject(Message::class.java)
                                chats.add(newChats)
                                scope.launch {
                                    chatState.animateScrollToItem(0)
                                }
                            }

                            onDispose {
                                viewModel.socket.off("messages-${conver!!.id}")
                                viewModel.socket.off("newMessage-${conver!!.id}")
                            }
                        }
                    }
                    fileRecipient.onNavResult { result ->
                        when (result) {
                            is NavResult.Canceled -> {}
                            is NavResult.Value -> {
                                files = result.value.toObjectList(MediaModel::class.java)
                            }
                        }
                    }

                    awardResult.onNavResult { result ->
                        when (result) {
                            is NavResult.Canceled -> {}
                            is NavResult.Value -> {
                                proposal = result.value
                                if (user != null) {
                                    viewModel.getConvr(id, user.id)
                                }
                            }
                        }
                    }

                    var replyTo by remember {
                        mutableStateOf<Message?>(null)
                    }
                    var showOption by remember {
                        mutableStateOf(false)
                    }

                    var message by remember { mutableStateOf(TextFieldValue("")) }

                    val selectedChats = remember {
                        mutableStateListOf<Message>()
                    }
                    var deleteCon by remember {
                        mutableStateOf(false)
                    }
                    congratsResult.onNavResult { result ->
                        when (result) {
                            is NavResult.Canceled -> {}
                            is NavResult.Value -> {
                                message =
                                    TextFieldValue("Thank you for the contract, I will get started on it immediately")
                            }
                        }
                    }
                    Column(Modifier.fillMaxSize()) {
                        Spacer(modifier = Modifier.height(16.dp))
                        Row(
                            Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row {
                                IconButton(onClick = { navigator.popBackStack() }) {
                                    Image(
                                        painter = painterResource(id = R.drawable.arrow_back),
                                        contentDescription = "Back",
                                        contentScale = ContentScale.FillWidth,
                                        modifier = Modifier.width(24.dp)
                                    )
                                }
                                var isLoading by remember {
                                    mutableStateOf(false)
                                }
                                AsyncImage(
                                    model = conver?.display?.image?.replace(Regex("\\bhttp://"), "https://")
                                        ?: "https://cdn.cakkie.com/imgs/Cakkie%20Icon%20(6).png",
                                    contentDescription = "profile pic",
                                    onState = {
                                        //update isLoaded
                                        isLoading = it is AsyncImagePainter.State.Loading
                                    },
                                    modifier = Modifier
                                        .size(40.dp)
                                        .clip(shape = CircleShape)
                                        .clickable {

                                        }
                                        .placeholder(
                                            visible = isLoading,
                                            highlight = PlaceholderHighlight.shimmer(),
                                            color = AppColor.copy(0.8f)
                                        )
                                        .fillMaxWidth(),
                                    contentScale = ContentScale.Crop,
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Column {
                                    Text(
                                        text = conver?.display?.name ?: "Cakkie Support",
                                        color = Color.Black,
                                        style = MaterialTheme.typography.bodyLarge,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Text(
                                        text = if (conver?.display?.isOnline == true) "Online" else "Offline",
                                        color = AppColor,
                                        style = MaterialTheme.typography.bodyLarge,
                                        fontSize = 14.sp
                                    )
                                }
                            }

                            IconButton(onClick = { showOption = true }) {
                              Icon(Icons.Default.MoreVert,
                                    contentDescription = "Back",
                                    contentScale = ContentScale.FillWidth,
                                    modifier = Modifier.width(24.dp)
                                )
                            }
                        }
                        AnimatedVisibility(visible = proposal != null) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
//                        if (proposal != null) {
//                            navigator.navigate(
//                                AwardContractDestination(
//                                    proposal = proposal!!
//                                )
//                            )
//                        }

                                        if (proposal?.status == "PENDING") {
                                            if (user?.id == conver?.byUserId) navigator.navigate(
                                                AwardContractDestination(
                                                    proposal = proposal!!
                                                )
                                            )
//                            else {}
                                        } else if (conver?.Order != null) {
                                            Timber.d("Order: ${conver?.Order}")
                                            if (user?.id == conver?.byUserId) navigator.navigate(
                                                OrderDetailsDestination(
                                                    conver?.Order!!.id
                                                )
                                            )
                                            else navigator.navigate(
                                                ContractDetailDestination(conver?.Order!!.id)
                                            )
                                        }
                                    }
                                    .background(CakkieBrown002)
                                    .height(40.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = if (proposal?.status == "PENDING") {
                                        if (user?.id == conver?.byUserId) "Award Contract"
                                        else "Awaiting Contract Award"
                                    } else {
                                        "View Order"
                                    },
                                    color = CakkieBackground,
                                    style = MaterialTheme.typography.bodyLarge,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 18.sp
                                )
                            }
                        }
                        LazyColumn(
                            Modifier.weight(1f),
                            state = chatState,
                            reverseLayout = true
                        ) {
                            val sortedChat = chats.sortedBy { it.createdAt }.reversed()
                            items(items = sortedChat, key = { index -> index.id }) {
                                val index = sortedChat.indexOf(it)
                                if (index > sortedChat.lastIndex - 2 && chatRes?.data?.isNotEmpty() == true) {
                                    chatRes?.meta?.let { page ->
                                        viewModel.getMessages(conver!!.id, page.nextPage, page.pageSize)
                                    }
                                }
                                ChatItem(
                                    it,
                                    viewModel,
                                    user,
                                    canSelect = selectedChats.isNotEmpty(),
                                    selected = selectedChats.map { it.id }.contains(it.id),
                                    onSelect = {
                                        if (selectedChats.map { it.id }.contains(it.id)) {
                                            selectedChats.removeIf { chat -> chat.id == it.id }
                                        } else {
                                            selectedChats.add(it)
                                        }
                                    },
                                ) {
                                    replyTo = it
                                }
                            }
                        }
                        AnimatedVisibility(files.isNotEmpty()) {
                            Card(
                                Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 12.dp),
                                shape = CardDefaults.elevatedShape,
                                colors = CardDefaults.cardColors(
                                    containerColor = CakkieBackground,
                                ),
                            ) {
                                Row(
                                    Modifier
                                        .horizontalScroll(rememberScrollState())
                                        .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
                                ) {
                                    files.forEach {
                                        Card(
                                            Modifier
                                                .padding(vertical = 5.dp, horizontal = 3.dp)
                                                .size(80.dp, 60.dp),
                                            shape = CardDefaults.elevatedShape,
                                            colors = CardDefaults.cardColors(
                                                containerColor = CakkieBackground,
                                            ),
                                            elevation = CardDefaults.cardElevation(
                                                defaultElevation = 4.dp
                                            )
                                        ) {
                                            Box(modifier = Modifier.fillMaxSize()) {
                                                GlideImage(
                                                    model = it.uri,
                                                    contentDescription = it.name,
                                                    modifier = Modifier
                                                        .size(80.dp, 60.dp),
                                                    contentScale = ContentScale.Crop
                                                )
                                                IconButton(
                                                    onClick = {
                                                        files = files.filter { file -> file.uri != it.uri }
                                                    }, modifier = Modifier
                                                        .align(Alignment.Center)
                                                ) {
                                                    Icon(
                                                        painter = painterResource(id = R.drawable.cancel),
                                                        contentDescription = "cancel",
                                                        tint = CakkieBackground,
                                                        modifier = Modifier
                                                            .background(
                                                                CakkieBrown.copy(0.5f), shape = CircleShape
                                                            )
                                                            .size(24.dp)
                                                            .align(Alignment.Center)
                                                    )
                                                }
                                            }
                                        }

                                    }
                                }
                            }
                            Spacer(modifier = Modifier.padding(8.dp))
                        }
                        AnimatedVisibility(replyTo != null) {
//            Spacer(modifier = Modifier.padding(8.dp))
                            Box(
                                Modifier
                                    .heightIn(max = 80.dp)
                                    .fillMaxWidth()
                            ) {
                                Card(
                                    Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 12.dp, vertical = 8.dp),
                                    shape = CardDefaults.elevatedShape,
                                    colors = CardDefaults.cardColors(
                                        containerColor = Color.Black.copy(0.5f),
                                    ),
                                ) {
                                    Row(
                                        Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        Column(Modifier.weight(1f)) {
                                            Spacer(modifier = Modifier.height(10.dp))
                                            Text(
                                                text = if (replyTo?.user?.id == user?.id) "You"
                                                else replyTo?.user?.name ?: "",
                                                color = CakkieOrange,
                                                style = MaterialTheme.typography.bodyLarge,
//                                fontWeight = FontWeight.Bold,
                                                modifier = Modifier.padding(horizontal = 10.dp),
                                                fontSize = 14.sp
                                            )
                                            Spacer(modifier = Modifier.height(2.dp))
                                            Text(
                                                text = replyTo?.text ?: "",
                                                maxLines = 2,
                                                color = CakkieBackground,
                                                style = MaterialTheme.typography.bodyLarge,
                                                modifier = Modifier.padding(horizontal = 10.dp),
                                                overflow = TextOverflow.Ellipsis,
                                            )
                                            Spacer(modifier = Modifier.height(15.dp))
                                        }
                                        if (replyTo?.media != null) {
                                            Box(
                                                modifier = Modifier
                                                    .width(60.dp)
                                                    .fillMaxHeight()
                                            ) {
                                                GlideImage(
                                                    model = replyTo!!.media,
                                                    contentDescription = "chat image",
                                                    modifier = Modifier
                                                        .fillMaxSize()
                                                        .background(CakkieBrown.copy(alpha = 0.5f)),
                                                    contentScale = ContentScale.Crop
                                                )
                                            }
                                        }
                                    }
                                }
                                IconButton(
                                    onClick = {
                                        replyTo = null
                                    }, modifier = Modifier
                                        .offset(x = (-6).dp)
                                        .align(Alignment.TopEnd)
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.cancel),
                                        contentDescription = "cancel",
                                        tint = CakkieBackground,
                                        modifier = Modifier
                                            .background(
                                                CakkieBrown.copy(0.5f), shape = CircleShape
                                            )
                                            .size(24.dp)
                                    )
                                }
                            }
//            Spacer(modifier = Modifier.padding(8.dp))
                        }
                        if (conver?.isActive == true || conver == null) {
                            Card(
                                Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 16.dp),
                                shape = CardDefaults.elevatedShape,
                                colors = CardDefaults.cardColors(
                                    containerColor = CakkieBackground
                                ),
                                elevation = CardDefaults.cardElevation(
                                    defaultElevation = 8.dp
                                )
                            ) {
                                Row(Modifier.fillMaxWidth()) {
                                    TextField(
                                        value = message,
                                        onValueChange = { message = it },
                                        placeholder = {
                                            Text(
                                                text = "Type a message",
                                                color = TextColorInactive,
                                                style = MaterialTheme.typography.bodyLarge,
                                                fontSize = 14.sp
                                            )
                                        },
                                        modifier = Modifier.fillMaxWidth(),
                                        textStyle = MaterialTheme.typography.bodyLarge,
                                        leadingIcon = {
                                            IconButton(onClick = {
                                                navigator.navigate(ChooseMediaDestination(from = "chat"))
                                            }) {
                                                Image(
                                                    painter = painterResource(id = R.drawable.fluent_attach),
                                                    contentDescription = "Back",
                                                    contentScale = ContentScale.FillWidth,
                                                    modifier = Modifier.width(24.dp)
                                                )
                                            }
                                        },
                                        trailingIcon = {
                                            AnimatedVisibility(visible = message.text.isNotEmpty() || files.isNotEmpty()) {
                                                IconButton(onClick = {
                                                    if (user != null) {
                                                        val fileUrls = files.map {
                                                            val file = context.createTmpFileFromUri(
                                                                uri = it.uri.toUri(),
                                                                fileName = it.name.replace(" ", "").take(10)
                                                            )!!
                                                            FileModel(
                                                                file = file,
                                                                url = Endpoints.FILE_URL(
                                                                    "${
                                                                        user.username.lowercase(Locale.ROOT)
                                                                            .replace(" ", "")
                                                                    }/${file.name.replace(" ", "")}.${
                                                                        it.mediaMimeType.split("/").last()
                                                                    }"
                                                                ),
                                                                mediaMimeType = it.mediaMimeType.split("/").last()
                                                            )
                                                        }
                                                        fileUrls.forEach {
                                                            viewModel.uploadImage(
                                                                image = it.file,
                                                                path = user.username.lowercase(Locale.ROOT)
                                                                    .replace(" ", ""),
                                                                fileName = "${it.file.name}.${it.mediaMimeType}"
                                                            ).addOnSuccessListener { resp ->
                                                                Timber.d(resp)
                                                                it.file.delete()
                                                            }.addOnFailureListener { exception ->
                                                                Timber.d(exception)
                                                                Toaster(
                                                                    context,
                                                                    exception.message.toString(),
                                                                    R.drawable.logo
                                                                )
                                                                it.file.delete()
                                                            }
                                                        }
                                                        if (conver == null) {
                                                            viewModel.startChat(
                                                                forAdmins = id == "support",
                                                                shopId = shopId,
                                                                content = message.text,
                                                                media = fileUrls.ifEmpty { null }?.first()?.url,
                                                                proposalId = if (idIsProposal) id else null
                                                            ).addOnSuccessListener {
                                                                conver = it
                                                                message = TextFieldValue("")
                                                                replyTo = null
                                                                files = emptyList()
                                                            }.addOnFailureListener {
                                                                Toaster(
                                                                    context,
                                                                    it,
                                                                    R.drawable.logo
                                                                ).show()
                                                            }
                                                        } else {

                                                            viewModel.sendMessages(
                                                                userId = user.id,
                                                                conversationId = conver!!.id,
                                                                text = message.text,
                                                                media = fileUrls.ifEmpty { null }?.first()?.url,
                                                                replyTo = replyTo?.id
                                                            )
                                                            message = TextFieldValue("")
                                                            replyTo = null
                                                            files = emptyList()
                                                        }
                                                    }
                                                }) {
                                                    Image(
                                                        painter = painterResource(id = R.drawable.send_fill),
                                                        contentDescription = "Back",
                                                        contentScale = ContentScale.FillWidth,
                                                        modifier = Modifier.width(24.dp)
                                                    )
                                                }
                                            }
                                        },
                                        colors = TextFieldDefaults.textFieldColors(
                                            backgroundColor = Color.Transparent,
                                            focusedIndicatorColor = Color.Transparent,
                                            unfocusedIndicatorColor = Color.Transparent,
                                            cursorColor = CakkieBrown,
                                            textColor = TextColorDark
                                        )
                                    )
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                    }

                    AnimatedVisibility(visible = showOption) {
                        Popup(alignment = Alignment.TopEnd, onDismissRequest = { showOption = false }) {
                            Card(
                                Modifier.padding(16.dp),
                                shape = CardDefaults.elevatedShape,
                                colors = CardDefaults.cardColors(
                                    containerColor = CakkieBackground
                                ),
                                elevation = CardDefaults.cardElevation(
                                    defaultElevation = 8.dp
                                )
                            ) {
                                Column(
                                    Modifier.padding(16.dp)
                                ) {
                                    Row(Modifier.clickable {
                                        showOption = false
                                        navigator.navigate(ReportDestination(name = "Sweet bites"))
                                    }, verticalAlignment = Alignment.CenterVertically) {
                                        Icon(
                                            painter = painterResource(id = R.drawable.report),
                                            contentDescription = stringResource(
                                                id = R.string.report
                                            ),
                                            tint = CakkieBrown,
                                            modifier = Modifier.size(24.dp)
                                        )
                                        Spacer(modifier = Modifier.width(8.dp))
                                        Text(
                                            text = stringResource(id = R.string.report_user),
                                            color = TextColorDark,
                                            style = MaterialTheme.typography.bodyLarge,
                                            fontWeight = FontWeight.Bold
                                        )
                                    }
                                }
                            }
                        }
                    }

                    AnimatedVisibility(visible = selectedChats.isNotEmpty()) {
                        Popup(alignment = Alignment.BottomCenter, onDismissRequest = { }) {
                            Card(
                                Modifier.fillMaxWidth(),
                                shape = RoundedCornerShape(16.dp, 16.dp, 0.dp, 0.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = CakkieBackground
                                ),
                                elevation = CardDefaults.cardElevation(
                                    defaultElevation = 8.dp
                                )
                            ) {
                                Row(
                                    Modifier
                                        .fillMaxWidth()
                                        .padding(16.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceEvenly
                                ) {
                                    listOf(
                                        Pair(R.drawable.copy, R.string.copy),
                                        Pair(R.drawable.share, R.string.reply),
                                        Pair(R.drawable.delete, R.string.delete)
                                    ).filter {
                                        if (selectedChats.size > 1) {
                                            it.second != R.string.reply
                                        } else {
                                            true
                                        }
                                    }.forEach {
                                        Column(
                                            Modifier.clickable {
                                                when (it.second) {
                                                    R.string.copy -> {
                                                        // copy
                                                        clipboardManager.setText(
                                                            AnnotatedString(
                                                                selectedChats.joinToString(
                                                                    "\n"
                                                                )
                                                            )
                                                        )
                                                        selectedChats.clear()
                                                        Toaster(
                                                            context,
                                                            "Copied to clipboard",
                                                            R.drawable.logo
                                                        ).show()
                                                    }

                                                    R.string.reply -> {
                                                        // reply
                                                        replyTo = selectedChats.first()
                                                        selectedChats.clear()
                                                    }

                                                    R.string.delete -> {
                                                        // delete
                                                        deleteCon = true
                                                    }
                                                }
                                            },
                                            horizontalAlignment = Alignment.CenterHorizontally
                                        ) {
                                            Icon(
                                                painter = painterResource(id = it.first),
                                                contentDescription = stringResource(
                                                    id = it.second
                                                ),
                                                tint = CakkieBrown,
                                                modifier = Modifier.size(24.dp)
                                            )
                                            Spacer(modifier = Modifier.width(8.dp))
                                            Text(
                                                text = stringResource(id = it.second),
                                                color = TextColorDark,
                                                style = MaterialTheme.typography.bodyLarge,
                                                fontWeight = FontWeight.Bold
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }

                    AnimatedVisibility(visible = deleteCon) {
                        Popup(alignment = Alignment.BottomCenter, onDismissRequest = { }) {
                            Card(
                                Modifier.fillMaxWidth(),
                                shape = RoundedCornerShape(16.dp, 16.dp, 0.dp, 0.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = CakkieBackground
                                ),
                                elevation = CardDefaults.cardElevation(
                                    defaultElevation = 8.dp
                                )
                            ) {
                                Row(
                                    Modifier
                                        .fillMaxWidth()
                                        .padding(16.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Icon(
                                            painter = painterResource(id = R.drawable.delete),
                                            contentDescription = "cancel",
                                            tint = CakkieBrown,
                                            modifier = Modifier.size(24.dp)
                                        )
                                        Spacer(modifier = Modifier.width(8.dp))
                                        Text(
                                            text = "Delete Message${if (selectedChats.size > 1) "s" else ""}?",
                                            color = TextColorDark,
                                            style = MaterialTheme.typography.bodyLarge,
                                            fontWeight = FontWeight.Bold
                                        )
                                    }

                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        IconButton(
                                            onClick = {
                                                selectedChats.forEach {
                                                    viewModel.deleteChat(
                                                        userId = user!!.id,
                                                        messageId = it.id
                                                    )
                                                }
                                                deleteCon = false
                                                selectedChats.clear()
                                            }
                                        ) {
                                            Text(
                                                text = "Yes",
                                                color = Error,
                                                style = MaterialTheme.typography.bodyLarge,
                                                fontWeight = FontWeight.Bold
                                            )
                                        }
                                        Spacer(modifier = Modifier.width(8.dp))
                                        IconButton(
                                            onClick = {
                                                deleteCon = false
                                            }
                                        ) {
                                            Text(
                                                text = "No",
                                                color = TextColorDark,
                                                style = MaterialTheme.typography.bodyLarge,
                                                fontWeight = FontWeight.Bold
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

    }
}