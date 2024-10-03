package com.example.vhh.ui.healthcare

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vhh.R
import com.example.vhh.ui.theme.AppColor
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@ExperimentalComposeUiApi
@Destination
@Composable
fun HealthEducation(    navigator: DestinationsNavigator
) {
    val scrollState = rememberScrollState()
//    val lazyGridState = rememberLazyGridState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(color = MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
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
                Image(painter = painterResource(id = R.drawable.whitesms), contentDescription = "",
                    modifier = Modifier.clickable { })
                Text(
                    text = stringResource(id = R.string.health_education),
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                    color = Color.White,
                    modifier = Modifier
                        .paddingFromBaseline(top = 10.dp)
                )
                Image(painter = painterResource(id = R.drawable.bell),
                    contentDescription = "",
                    modifier
                    = Modifier.clickable { })
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Image(
            painterResource(R.drawable.health), contentDescription = null,
            modifier = Modifier.padding(start = 10.dp, end = 10.dp)
        )
        Spacer(Modifier.height(20.dp))
        Text(
            stringResource(R.string.water_sanitation_and_hygiene),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(20.dp))
Row (
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.Start,
    modifier = Modifier.padding(start = 10.dp, end = 50.dp)
){
    Text(
        stringResource(R.string.water),
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        color = AppColor,
    )
    Text(
        text = ":",
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        color = AppColor,
    )
}
        Spacer(Modifier.height(10.dp))
        Image(
            painterResource(R.drawable.water), contentDescription = null,
            modifier = Modifier.padding(start = 10.dp, end = 10.dp)
        )
                    Spacer(Modifier.height(20.dp))
Row (
    verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start,
    modifier = Modifier.padding(start = 10.dp, end = 50.dp)
){
    Text(
        stringResource(R.string.sanitation),
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        color = AppColor,
    )
    Text(
        text = ":",
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        color = AppColor,
    )
}
        Spacer(Modifier.height(10.dp))
        Image(
            painterResource(R.drawable.water), contentDescription = null,
            modifier = Modifier.padding(start = 10.dp, end = 10.dp)
        )
        Spacer(Modifier.height(20.dp))
Row (
    verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start,
    modifier = Modifier.padding(start = 10.dp, end = 50.dp)
){
    Text(
        stringResource(R.string.hygiene),
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        color = AppColor,
    )
    Text(
        text = ":",
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        color = AppColor,
    )
}
        Spacer(Modifier.height(10.dp))
        Image(
            painterResource(R.drawable.water), contentDescription = null,
            modifier = Modifier.padding(start = 10.dp, end = 10.dp)
        )

    }
}