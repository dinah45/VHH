package com.example.vhh.ui.telemedcine

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vhh.R
import com.example.vhh.ui.theme.AppColor

@Composable
fun Video1 () {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.Start
    ) {
        Image(
            painterResource(R.drawable.doc),
            contentDescription = null,
//                modifier = Modifier.fillMaxSize()
        )
    }
    Spacer(modifier = Modifier.height(15.dp))
    Surface(
        modifier = Modifier.size(50.dp),
        color = AppColor, shape = RoundedCornerShape(50)
    ) {
        Image(painterResource(R.drawable.arrow), contentDescription = null)
    }
    Surface(
        modifier = Modifier
            .padding(top = 520.dp)
            .fillMaxWidth().height(270.dp),
        color = Color.White
    ) {
        Column {
            Text(
                "Rate Dr Matthew",
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 30.dp, start = 60.dp)
            )
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                modifier = Modifier.padding(start = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    "Excellent",
                    fontWeight = FontWeight.Medium,
                    fontSize = 17.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.width(15.dp))
                Image(painterResource(R.drawable.star2), contentDescription = null)
                Image(painterResource(R.drawable.star2), contentDescription = null)
                Image(painterResource(R.drawable.star2), contentDescription = null)
                Image(painterResource(R.drawable.star2), contentDescription = null)
                Image(painterResource(R.drawable.star2), contentDescription = null)
            }
            Spacer(modifier = Modifier.height(15.dp))

            Row(
                modifier = Modifier.padding(start = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    "Good",
                    fontWeight = FontWeight.Medium,
                    fontSize = 17.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.width(50.dp))
                Image(painterResource(R.drawable.star2), contentDescription = null)
                Image(painterResource(R.drawable.star2), contentDescription = null)
                Image(painterResource(R.drawable.star2), contentDescription = null)
                Image(painterResource(R.drawable.star2), contentDescription = null)
            }
            Spacer(modifier = Modifier.height(15.dp))

            Row(
                modifier = Modifier.padding(start = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    "Fair",
                    fontWeight = FontWeight.Medium,
                    fontSize = 17.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.width(55.dp))
                Image(painterResource(R.drawable.star2), contentDescription = null)
                Image(painterResource(R.drawable.star2), contentDescription = null)
                Image(painterResource(R.drawable.star2), contentDescription = null)
            }
        }
    }
}


