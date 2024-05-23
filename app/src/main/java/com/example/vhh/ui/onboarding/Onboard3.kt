package com.example.vhh.ui.onboarding


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vhh.R
import com.example.vhh.ui.destinations.LoginDestination
import com.example.vhh.ui.destinations.Onboard4Destination
import com.example.vhh.ui.destinations.StartDestination
import com.example.vhh.ui.theme.AppColor
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@ExperimentalComposeUiApi
@Destination
@Composable
fun Onboard3 (navigator: DestinationsNavigator) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray.copy(0.7f))

    ) {
        Image(
            painter = painterResource(id = R.drawable.nurse3), contentDescription = "",
            modifier = Modifier.fillMaxSize()
        )
    }
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Card(modifier = Modifier
                .wrapContentSize()
                .wrapContentHeight()
                .width(70.dp)
                .padding(end = 16.dp)
                .align(Alignment.End)
                .clickable { navigator.navigate(StartDestination) },
                backgroundColor = AppColor,
                contentColor = Color.White,
                shape = RoundedCornerShape(20.dp)
            ) {
                Text(text = stringResource(id = R.string.skip),
                    color = Color.White,
                    textAlign = TextAlign.Center)
            }
            Spacer(modifier = Modifier.height(230.dp))

            Text(text = stringResource(id = R.string.telemedicine_consultation), fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color.White,
                modifier = Modifier.padding(start = 50.dp, end = 50.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = stringResource(id = R.string.connect_with_qualified),
                fontSize = 15.sp,
                textAlign = TextAlign.Center,
                color = Color.White.copy(0.7f),
                modifier = Modifier.padding(start = 20.dp, end = 16.dp)
            )
            Spacer(modifier = Modifier.height(80.dp))
            Image(painter = painterResource(id = R.drawable.next), contentDescription = "",
                modifier = Modifier.clickable {navigator.navigate(Onboard4Destination)  }
                    .size(60.dp).align(Alignment.CenterHorizontally)
            )
        }
    }