package com.example.vhh.ui.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import com.example.vhh.ui.theme.AppColor


@Composable
fun Onboard1 () {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray.copy(0.7f))

    ) {
        Image(
            painter = painterResource(id = R.drawable.snurse1), contentDescription = "",
            modifier = Modifier.fillMaxSize()
        )
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
modifier = Modifier
    .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Spacer(modifier = Modifier.height(50.dp))
Card(modifier = Modifier
    .wrapContentSize()
    .wrapContentHeight()
    .width(70.dp)
    .padding(end = 16.dp)
    .align(Alignment.End),
    backgroundColor = AppColor,
    contentColor = Color.White,
    shape = RoundedCornerShape(20.dp)
) {
    Text(text = stringResource(id = R.string.skip),
        color = Color.White,
        textAlign = TextAlign.Center)
}
            Spacer(modifier = Modifier.height(200.dp))

            Text(text = stringResource(id = R.string.health_education), fontSize = 28.sp,
                fontWeight = FontWeight.Bold, color = Color.White,
                modifier = Modifier.padding(start = 60.dp)
                )
            Row (
                modifier = Modifier.padding(start = 80.dp)
            ){
                Text(
                    text = "&", fontSize = 28.sp,
                    fontWeight = FontWeight.Bold, color = Color.White,
                )
                Text(
                    text = stringResource(id = R.string.awarness), fontSize = 28.sp,
                    fontWeight = FontWeight.Bold, color = Color.White,
                )
            }
            Text(
                text = stringResource(id = R.string.educational_resources_and_information),
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier.padding(start = 20.dp, end = 16.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))
            Card(modifier = Modifier
                .wrapContentSize()
                .wrapContentHeight()
                .width(70.dp)
                .padding(end = 16.dp)
                .align(Alignment.CenterHorizontally),
                backgroundColor = AppColor,
                shape = RoundedCornerShape(50)
            ) {
                Image(imageVector = Icons.Default.ArrowForward, contentDescription = "",
                    modifier = Modifier,
                    contentScale = ContentScale.Fit,
                    )
            }
        }
    }
}