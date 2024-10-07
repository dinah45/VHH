package com.example.vhh.ui.notification

import android.app.Notification
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.vhh.R
import com.example.vhh.ui.theme.AppColor
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@Composable
fun NotificationItem(item: Notification, isBackground: Boolean, navigator: DestinationsNavigator) {
    Row {
        if (isBackground) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(60.dp)
                    .background(Color.Red),
                contentAlignment = Alignment.Center
            ) {
                Icon(Icons.Default.Delete,
                    contentDescription = "delete",
                    modifier = Modifier
                        .size(24.dp)
                )
            }
        }

        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(horizontal = 16.dp, vertical = 8.dp)
//                .height(65.dp)
                .clickable {
//                    navigator.navigate(
//                        AuthNotificationDestination
//                    )
                }

        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.SemiBold,
                )

                Text(
                    text = item.createdAt.formatDate(),
                    style = MaterialTheme.typography.bodyLarge,
                    color = AppColor.copy(alpha = 0.5f),
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = item.message,
                style = MaterialTheme.typography.bodyLarge,
                color = AppColor.copy(alpha = 0.5f),
            )
        }
    }

}