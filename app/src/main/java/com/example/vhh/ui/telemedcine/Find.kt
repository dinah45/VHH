package com.example.vhh.ui.telemedcine

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material3.Text
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
import com.example.vhh.ui.components.SearchBar
import com.example.vhh.ui.theme.AppColor
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@ExperimentalComposeUiApi
@Destination
@Composable
fun Find (
//fun Medication(    navigator: DestinationsNavigator
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
                Image(painter = painterResource(id = R.drawable.arrow), contentDescription = "",
                    modifier = Modifier.clickable { })
                Spacer(modifier = Modifier.weight(1f))
                Image(painter = painterResource(id = R.drawable.vec), contentDescription = "",
                    modifier = Modifier.clickable { })
                Spacer(modifier = Modifier.width(10.dp))
                Image(painter = painterResource(id = R.drawable.bell),
                    contentDescription = "",
                    modifier
                    = Modifier.clickable { })
            }
            Text(
                text = stringResource(id = R.string.find_doctor),
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 100.dp)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = stringResource(R.string.gynacologist),
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(end = 170.dp)
            )
        Spacer(modifier = Modifier.height(20.dp))

        Row (
            modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ){
Image(painterResource(R.drawable.frame), contentDescription = null)
            Spacer(modifier = Modifier.weight(1f))
Image(painterResource(R.drawable.frame), contentDescription = null)
            Spacer(modifier = Modifier.weight(1f))
                    Image(painterResource(R.drawable.frame), contentDescription = null)
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row (
            modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ){
Image(painterResource(R.drawable.frame), contentDescription = null)
            Spacer(modifier = Modifier.weight(1f))
Image(painterResource(R.drawable.frame), contentDescription = null)
            Spacer(modifier = Modifier.weight(1f))
                    Image(painterResource(R.drawable.frame), contentDescription = null)
            Spacer(modifier = Modifier.height(20.dp))
        }
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = stringResource(R.string.heart_spaecialty),
            fontSize = 20.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(end = 170.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row (
            modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ){
Image(painterResource(R.drawable.frame), contentDescription = null)
            Spacer(modifier = Modifier.weight(1f))
Image(painterResource(R.drawable.frame), contentDescription = null)
            Spacer(modifier = Modifier.weight(1f))
                    Image(painterResource(R.drawable.frame), contentDescription = null)
            Spacer(modifier = Modifier.height(20.dp))
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row (
            modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ){
Image(painterResource(R.drawable.frame), contentDescription = null)
            Spacer(modifier = Modifier.weight(1f))
Image(painterResource(R.drawable.frame), contentDescription = null)
            Spacer(modifier = Modifier.weight(1f))
                    Image(painterResource(R.drawable.frame), contentDescription = null)
        }
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = stringResource(R.string.gynacologist),
            fontSize = 20.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(end = 170.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row (
            modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ){
Image(painterResource(R.drawable.frame), contentDescription = null)
            Spacer(modifier = Modifier.weight(1f))
Image(painterResource(R.drawable.frame), contentDescription = null)
            Spacer(modifier = Modifier.weight(1f))
                    Image(painterResource(R.drawable.frame), contentDescription = null)
        }
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = stringResource(R.string.physiologist),
            fontSize = 20.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(end = 170.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row (
            modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ){
Image(painterResource(R.drawable.frame), contentDescription = null)
            Spacer(modifier = Modifier.weight(1f))
Image(painterResource(R.drawable.frame), contentDescription = null)
            Spacer(modifier = Modifier.weight(1f))
                    Image(painterResource(R.drawable.frame), contentDescription = null)
            Spacer(modifier = Modifier.height(20.dp))
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row (
            modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ){
Image(painterResource(R.drawable.frame), contentDescription = null)
            Spacer(modifier = Modifier.weight(1f))
Image(painterResource(R.drawable.frame), contentDescription = null)
            Spacer(modifier = Modifier.weight(1f))
                    Image(painterResource(R.drawable.frame), contentDescription = null)
            Spacer(modifier = Modifier.height(20.dp))
        }

    }
}