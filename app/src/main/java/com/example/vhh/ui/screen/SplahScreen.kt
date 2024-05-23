package com.example.vhh.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.vhh.R
import com.example.vhh.ui.destinations.WelcomeDestination
import com.example.vhh.ui.theme.AppColor
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.delay

@ExperimentalComposeUiApi
@Destination
@RootNavGraph(start = true)
@Composable
fun SplashScreen(navigator: DestinationsNavigator) {
    LaunchedEffect(key1 = Unit) {
        delay(2000)
        navigator.navigate(WelcomeDestination)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColor), contentAlignment = Alignment.Center
    ) {
        Surface(
            modifier = Modifier
                .size(250.dp),
            shape = CircleShape,
            color = MaterialTheme.colorScheme.background
        ) {
            Image(painter = painterResource(id = R.drawable.logo), contentDescription = "")
        }
    }
}