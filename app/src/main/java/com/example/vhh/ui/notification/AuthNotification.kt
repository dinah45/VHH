package com.example.vhh.ui.notification

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vhh.R
import com.example.vhh.ui.components.VhhButton
import com.example.vhh.ui.theme.AppColor
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination
fun AuthNotification(navigator: DestinationsNavigator) {

    Column(
        Modifier
            .padding(vertical = 30.dp, horizontal = 16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.arrow),
            contentDescription = "Arrow Back",
            modifier = Modifier
                .align(Alignment.Start)
                .clickable {
                    navigator.popBackStack()
                }
                .size(24.dp)
        )
        Spacer(modifier = Modifier.height(80.dp))
        Text(
            text = stringResource(id = R.string.was_this_you),
            style = MaterialTheme.typography.bodyLarge,
            color = AppColor,
            fontWeight = FontWeight.SemiBold,
            fontSize = 25.sp
        )
        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = stringResource(id = R.string.unknown_device),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.fillMaxWidth(0.7f),
            textAlign = TextAlign.Center,
            color = Color.Black.copy(alpha = 0.7f)
        )
        Spacer(modifier = Modifier.height(30.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column {
                Text(
                    text = stringResource(id = R.string.location),
                    style = MaterialTheme.typography.bodyLarge,
                    color = AppColor

                )
                Text(
                    text = "Ikosi Ketu",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Black.copy(alpha = 0.7f)
                )
                Text(
                    text = "Lagos Nigeria",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Black.copy(alpha = 0.7f)
                )
            }

            Column {
                Text(
                    text = "Duration",
                    style = MaterialTheme.typography.bodyLarge,
                    color = AppColor

                )
                Text(
                    text = stringResource(id = R.string.greenish_meridian),
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Black.copy(alpha = 0.7f)
                )
                Text(
                    text = "Date",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Black.copy(alpha = 0.7f)
                )
            }

        }
        Spacer(modifier = Modifier.height(30.dp))
        Column {
            Text(
                text = stringResource(id = R.string.device_),
                style = MaterialTheme.typography.bodyLarge,
                color = AppColor

            )
            Text(
                text = stringResource(id = R.string.model_),
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Black.copy(alpha = 0.7f)
            )
        }
        Spacer(modifier = Modifier.height(52.dp))

        VhhButton (
            Modifier.height(50.dp),
            text = stringResource(id = R.string.yes_it_was_me)
        ) {}
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = stringResource(id = R.string.no_it_was_not_me),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
