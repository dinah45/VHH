package com.example.vhh.ui.telemedcine

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.vhh.R
import com.example.vhh.ui.theme.AppColor

@Composable
fun Video () {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painterResource(R.drawable.doc),
            contentDescription = null,
//                modifier = Modifier.fillMaxSize()
        )
    }
    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 34.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Surface(
            modifier = Modifier.size(50.dp),
            color = AppColor, shape = RoundedCornerShape(50)
        ) {
            Image(painterResource(R.drawable.arrow), contentDescription = null)
        }
        Spacer(modifier = Modifier.weight(1f))
        Image(painterResource(R.drawable.patient), contentDescription = null)
        Spacer(modifier = Modifier.weight(1f))
        Row {
            Surface(
                modifier = Modifier.size(100.dp),
                color = Color.White.copy(0.7f),
                shape = RoundedCornerShape(50)
            ) {
                Image(painterResource(R.drawable.mute), contentDescription = null)
            }
            Spacer(modifier = Modifier.weight(1f))
            Image(painterResource(R.drawable.end), contentDescription = null)
            Spacer(modifier = Modifier.weight(1f))
            Surface(
                modifier = Modifier.size(100.dp),
                color = Color.White.copy(0.7f),
                shape = RoundedCornerShape(50)
            ) {
                Image(painterResource(R.drawable.speaker), contentDescription = null)
            }
        }
    }
}



