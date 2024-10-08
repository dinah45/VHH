package com.example.vhh.ui.notification


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vhh.R
import com.example.vhh.ui.networkModels.Notification
import com.example.vhh.ui.networkModels.NotificationResponse
import com.example.vhh.ui.theme.AppColor
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterialApi::class)
@ExperimentalComposeUiApi
@Destination
@Composable
fun Notification(
    navigator: DestinationsNavigator) {
    val viewModel: NotificationViewModel = koinViewModel()
    val notifications = viewModel.notifications.observeAsState(NotificationResponse()).value
    val noti = remember {
        mutableStateListOf<Notification>()
    }
    val showTip = viewModel.isNotificationTipShown.collectAsState(true).value

    LaunchedEffect(key1 = notifications.data) {
        noti.addAll(notifications?.data?.filterNot { res ->
            noti.any { it.id == res.id }
        } ?: emptyList())
    }
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(color = MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(bottomEnd = 40.dp, bottomStart = 40.dp))
                .height(150.dp),
            backgroundColor = AppColor
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 24.dp),
                horizontalArrangement = Arrangement.Absolute.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Image(painter = painterResource(id = R.drawable.arrow), contentDescription = "",
                    modifier = Modifier.clickable { })
                Spacer(modifier = Modifier.weight(1f))
                Image(painter = painterResource(id = R.drawable.vec), contentDescription = "",
                    modifier = Modifier.clickable { })
                Spacer(modifier = Modifier.width(10.dp))
                Image(painter = painterResource(id = R.drawable.bell),
                    contentDescription = "",
                    modifier
                    = Modifier.clickable { })
            }
            Text(
                text = stringResource(id = R.string.notifications),
                fontWeight = FontWeight.Medium,
                fontSize = 25.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 100.dp)
            )
        }

        if (noti.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(colorResource(R.color.green_app), RoundedCornerShape(12.dp))
                    .clip(RoundedCornerShape(12.dp))
                    .height(70.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(id = R.string.no_notifications),
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
        LazyColumn(
            state = rememberLazyListState()
        ) {
            items(items = noti, key = { it.id }) { notification ->
                val index = noti.indexOf(notification)
                if (index > noti.lastIndex - 2 && notifications.data.isNotEmpty()) {
                    viewModel.getNotifications(
                        notifications.meta.nextPage,
                        notifications.meta.pageSize
                    )
                }
                NotificationItem(notification, isBackground = false, navigator = navigator )
//        NotificationItem(notification, isBackground = false, navigator = navigator)
//                    })
                Spacer(modifier = Modifier.height(8.dp))
            }

        }
    }

      }