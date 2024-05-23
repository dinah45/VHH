package com.example.vhh.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vhh.R
import com.example.vhh.ui.destinations.Onboard1Destination
import com.example.vhh.ui.theme.AppColor
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.delay

@ExperimentalComposeUiApi
@Destination
@Composable
fun Welcome(navigator: DestinationsNavigator) {
    LaunchedEffect(key1 = Unit) {
        delay(2000)
        navigator.navigate(Onboard1Destination)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColor),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Text(text = stringResource(id = R.string.welcome_to),
                fontSize = 24.sp,
                color = Color.White)
            Text(text = "VHH.",
                fontSize = 50.sp,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center, 
                modifier = Modifier.padding(20.dp), color = Color.White)
        }
    }
}