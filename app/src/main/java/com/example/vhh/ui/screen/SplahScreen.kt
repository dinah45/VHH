package com.example.vhh.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.vhh.R
import com.example.vhh.ui.theme.AppColor

@Composable
fun SplashScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColor), contentAlignment = Alignment.Center
    ) {
        Surface(
            modifier = Modifier
                .size(250.dp),
            shape = CircleShape,
            color = Color.White
        ) {
            Image(painter = painterResource(id = R.drawable.logo), contentDescription = "")
        }
    }
}