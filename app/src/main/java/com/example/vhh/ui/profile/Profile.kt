package com.example.vhh.ui.profile

import android.widget.PopupMenu.OnDismissListener
import android.widget.Space
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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
import androidx.compose.ui.window.Popup
import com.example.vhh.R
import com.example.vhh.ui.components.Custom
import com.example.vhh.ui.components.VhhButton
import com.example.vhh.ui.components.VhhButton1
import com.example.vhh.ui.theme.AppColor
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalMaterialApi::class)
@ExperimentalComposeUiApi
@Destination
@Composable
fun Profile (
   navigator: DestinationsNavigator
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(color = Color.LightGray.copy(0.5f)),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(bottomEnd = 40.dp, bottomStart = 40.dp))
                .height(250.dp),
            backgroundColor = AppColor
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 34.dp),
                horizontalArrangement = Arrangement.Absolute.SpaceBetween,
                verticalAlignment = Alignment.Top
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
                text = stringResource(id = R.string.profile),
                fontWeight = FontWeight.Medium,
                fontSize = 25.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 70.dp)
            )
        }
        Row(
            modifier = Modifier.padding(start = 15.dp, end = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Surface(
                modifier = Modifier.clickable { }.size(width = 170.dp, height = 120.dp),
                shape = RoundedCornerShape(20),
                color = Color.White.copy(0.7f),
            ) {
                Column(

                    modifier = Modifier,
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(painterResource(R.drawable.test), contentDescription = null)
                    Text(
                        "Test results", fontWeight = FontWeight.Medium,
                        fontSize = 13.sp,
                        color = Color.Black
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Surface(
                modifier = Modifier.clickable { }.size(width = 170.dp, height = 120.dp),
                shape = RoundedCornerShape(20),
                color = Color.White.copy(0.7f),
            ) {
                Column(

                    modifier = Modifier,
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(painterResource(R.drawable.alarm), contentDescription = null)
                    Text(
                        "Medication Schedule", fontWeight = FontWeight.Medium,
                        fontSize = 13.sp,
                        color = Color.Black
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.padding(start = 15.dp, end = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Surface(
                modifier = Modifier.clickable { }.size(width = 170.dp, height = 120.dp),
                shape = RoundedCornerShape(20),
                color = Color.White.copy(0.7f),
            ) {
                Column(

                    modifier = Modifier,
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(painterResource(R.drawable.tube), contentDescription = null)
                    Text(
                        "Prescription", fontWeight = FontWeight.Medium,
                        fontSize = 13.sp,
                        color = Color.Black
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Surface(
                modifier = Modifier.clickable { }.size(width = 170.dp, height = 120.dp),
                shape = RoundedCornerShape(20),
                color = Color.White.copy(0.7f),
            ) {
                Column(

                    modifier = Modifier,
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(painterResource(R.drawable.table), contentDescription = null)
                    Text(
                        "Medical history", fontWeight = FontWeight.Medium,
                        fontSize = 13.sp,
                        color = Color.Black
                    )
                }
            }
        }
Spacer(modifier = Modifier.height(15.dp))
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .size(32.dp)
                .padding(horizontal = 16.dp)
                .clickable { },
            shape = RoundedCornerShape(40),
            color = Color.White.copy(0.7f),
            contentColor = Color.Black) {
            Row(
                modifier = Modifier.padding(start = 20.dp, end = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    "Appointment history",
                    fontWeight = FontWeight.Normal,
                    fontSize = 13.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(Icons.Default.KeyboardArrowRight, contentDescription = null)
            }
        }

Spacer(modifier = Modifier.height(10.dp))
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .size(32.dp)
                .padding(horizontal = 16.dp)
                .clickable { },
            shape = RoundedCornerShape(40),
            color = Color.White.copy(0.7f),
            contentColor = Color.Black){
            Row(
                modifier = Modifier.padding(start = 20.dp, end = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    "Favourites ",
                    fontWeight = FontWeight.Normal,
                    fontSize = 13.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(Icons.Default.KeyboardArrowRight, contentDescription = null)
            }
        }

Spacer(modifier = Modifier.height(10.dp))
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .size(32.dp)
                .padding(horizontal = 16.dp)
                .clickable { },
            shape = RoundedCornerShape(40),
            color = Color.White.copy(0.7f),
            contentColor = Color.Black){
            Row(
                modifier = Modifier.padding(start = 20.dp, end = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    "Payment Info ",
                    fontWeight = FontWeight.Normal,
                    fontSize = 13.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(Icons.Default.KeyboardArrowRight, contentDescription = null)
            }
        }

Spacer(modifier = Modifier.height(10.dp))
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .size(32.dp)
                .padding(horizontal = 16.dp)
                .clickable { },
            shape = RoundedCornerShape(40),
            color = Color.White.copy(0.7f),
            contentColor = Color.Black){
            Row(
                modifier = Modifier.padding(start = 20.dp, end = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    "Settings ",
                    fontWeight = FontWeight.Normal,
                    fontSize = 13.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(Icons.Default.KeyboardArrowRight, contentDescription = null)
            }
        }

Spacer(modifier = Modifier.height(10.dp))
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .size(32.dp)
                .padding(horizontal = 16.dp)
                .clickable { },
            shape = RoundedCornerShape(40),
            color = Color.White.copy(0.7f),
            contentColor = Color.Black){
            Row(
                modifier = Modifier.padding(start = 20.dp, end = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    "Notification ",
                    fontWeight = FontWeight.Normal,
                    fontSize = 13.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(Icons.Default.KeyboardArrowRight, contentDescription = null)
            }
        }
Spacer(modifier = Modifier.height(10.dp))
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .size(32.dp)
                .padding(horizontal = 16.dp)
                .clickable { },
            shape = RoundedCornerShape(40),
            color = Color.White.copy(0.7f),
            contentColor = Color.Black){
            Row(
                modifier = Modifier.padding(start = 20.dp, end = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    "Support ",
                    fontWeight = FontWeight.Normal,
                    fontSize = 13.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(Icons.Default.KeyboardArrowRight, contentDescription = null)
            }
        }
        Text(
            "Log Out ",
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp,
            color = AppColor,
            modifier = Modifier.padding(start = 15.dp)
        )
        }
    }

