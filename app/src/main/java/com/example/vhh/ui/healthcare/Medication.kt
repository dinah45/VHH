package com.example.vhh.ui.healthcare

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vhh.R
import com.example.vhh.ui.components.Check
import com.example.vhh.ui.theme.AppColor
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@ExperimentalComposeUiApi
@Destination
@Composable
fun Medication(    navigator: DestinationsNavigator
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
                    text = stringResource(id = R.string.medication),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
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
        Surface(
            modifier = Modifier.fillMaxWidth()
                .height(163.dp)
                .padding(start = 20.dp)
                .background(color = colorResource(R.color.milk),
                    shape = RoundedCornerShape(20)),
            elevation = 2.dp
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Thursday, 23 May",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
//                            .padding(top = 10.dp, start = 30.dp)
                )
                Image(
                    painterResource(R.drawable.down), contentDescription = null,
                    modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
//                            .padding(start = 50.dp)
                )
                Row(
                    modifier = Modifier.fillMaxWidth().horizontalScroll(scrollState),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            "Mo",
                            fontWeight = FontWeight.Normal,
                            fontSize = 16.sp,
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Box(contentAlignment = Alignment.Center) {
                            Image(painterResource(R.drawable.rec), contentDescription = null)
                            Image(painterResource(R.drawable.active), contentDescription = null)
                        }
                    }
                    Spacer(modifier = Modifier.width(15.dp))

                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            "Tu",
                            fontWeight = FontWeight.Normal,
                            fontSize = 16.sp,
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Box(contentAlignment = Alignment.Center) {
                            Image(painterResource(R.drawable.rec), contentDescription = null)
                            Image(painterResource(R.drawable.active), contentDescription = null)
                        }
                    }
                    Spacer(modifier = Modifier.width(15.dp))
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            "We",
                            fontWeight = FontWeight.Normal,
                            fontSize = 16.sp,
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Box(contentAlignment = Alignment.Center) {
                            Image(painterResource(R.drawable.rec), contentDescription = null)
                            Image(painterResource(R.drawable.active), contentDescription = null)
                        }
                    }
                    Spacer(modifier = Modifier.width(15.dp))

                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            "Th",
                            fontWeight = FontWeight.Normal,
                            fontSize = 16.sp,
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Box(contentAlignment = Alignment.Center) {
                            Image(painterResource(R.drawable.rec), contentDescription = null)
                            Image(painterResource(R.drawable.active), contentDescription = null)
                        }
                    }
                    Spacer(modifier = Modifier.width(15.dp))
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            "Fr",
                            fontWeight = FontWeight.Normal,
                            fontSize = 16.sp,
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Box(contentAlignment = Alignment.Center) {
                            Image(
                                painterResource(R.drawable.rec),
                                contentDescription = null
                            )
                            Image(
                                painterResource(R.drawable.active),
                                contentDescription = null
                            )
                        }
                    }
                    Spacer(modifier = Modifier.width(15.dp))
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            "Sa",
                            fontWeight = FontWeight.Normal,
                            fontSize = 16.sp,
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Box(contentAlignment = Alignment.Center) {
                            Image(
                                painterResource(R.drawable.rec),
                                contentDescription = null
                            )
                            Image(
                                painterResource(R.drawable.inactive),
                                contentDescription = null
                            )
                        }
                    }
                    Spacer(modifier = Modifier.width(15.dp))
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            "Su",
                            fontWeight = FontWeight.Normal,
                            fontSize = 16.sp,
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Box(contentAlignment = Alignment.Center) {
                            Image(
                                painterResource(R.drawable.rec),
                                contentDescription = null
                            )
                            Image(
                                painterResource(R.drawable.inactive),
                                contentDescription = null
                            )
                        }
                    }
                }
            }
        }
                        Spacer(modifier = Modifier.height(15.dp))
                        Text(
                            stringResource(R.string.daily_dose),
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp,
                            color = Color.Black,
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                        Surface(
                            modifier = Modifier.fillMaxWidth()
                                .size(width = 391.dp, height = 80.dp)
                                .padding(start = 15.dp, end = 15.dp)
                                .background(color = colorResource(R.color.milk), shape = RoundedCornerShape(20)),
                            elevation = 2.dp
                        ) {
                            Row (modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                                verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start){
                                Column {
                                    Text(
                                        "10:12 AM",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 10.sp,
                                        color = Color.Black,
                                    )
                                    Text(
                                        stringResource(R.string.vitamin_c_d_and_selen),
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 10.sp,
                                        color = AppColor,
                                    )
                                }
                                Spacer(modifier = Modifier.weight(1f))
                                Check()
                            }
                        }
                        Spacer(modifier = Modifier.height(15.dp))
                        Surface(
                            modifier = Modifier.fillMaxWidth()
                                .size(width = 391.dp, height = 80.dp)
                                .padding(start = 15.dp, end = 15.dp)
                                .background(color = colorResource(R.color.milk), shape = RoundedCornerShape(20)),
                            elevation = 2.dp
                        ) {
                            Row (modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                                verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start){
                                Column {
                                    Text(
                                        "10:12 AM",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 10.sp,
                                        color = Color.Black,
                                    )
                                    Text(
                                        stringResource(R.string.vitamin_c_d_and_selen),
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 10.sp,
                                        color = AppColor,
                                    )
                                }
                                Spacer(modifier = Modifier.weight(1f))
                                Check()
                            }
                        }
                        Spacer(modifier = Modifier.height(15.dp))
                        Surface(
                            modifier = Modifier.fillMaxWidth()
                                .size(width = 391.dp, height = 80.dp)
                                .padding(start = 15.dp, end = 15.dp)
                                .clickable {  }
                                .background(color = colorResource(R.color.milk), shape = RoundedCornerShape(20)),
                            elevation = 2.dp
                        ) {
                            Row (modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                                verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start){
                                Column {
                                    Text(
                                        "10:12 AM",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 10.sp,
                                        color = Color.Black,
                                    )
                                    Text(
                                        stringResource(R.string.vitamin_c_d_and_selen),
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 10.sp,
                                        color = AppColor,
                                    )
                                }
                                Spacer(modifier = Modifier.weight(1f))
                                Check()
                            }
                        }
                        Spacer(modifier = Modifier.height(15.dp))
                        Surface(
                            modifier = Modifier.fillMaxWidth()
                                .size(width = 391.dp, height = 80.dp)
                                .padding(start = 15.dp, end = 15.dp)
                                .background(color = colorResource(R.color.milk), shape = RoundedCornerShape(20)),
                            elevation = 2.dp
                        ) {
                            Row (modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                                verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start){
                                Column {
                                    Text(
                                        "10:12 AM",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 10.sp,
                                        color = Color.Black,
                                    )
                                    Text(
                                        stringResource(R.string.vitamin_c_d_and_selen),
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 10.sp,
                                        color = AppColor,
                                    )
                                }
                                Spacer(modifier = Modifier.weight(1f))
                                Check()
                            }
                        }
                        Spacer(modifier = Modifier.height(15.dp))
                        Surface(
                            modifier = Modifier.fillMaxWidth()
                                .size(width = 391.dp, height = 80.dp)
                                .padding(start = 15.dp, end = 15.dp)
                                .background(Color.White.copy(0.7f), shape = RoundedCornerShape(20)),
                            elevation = 2.dp

                        ) {
                            Row (modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                                verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start){
                                Column {
                                    Text(
                                        "10:12 AM",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 10.sp,
                                        color = Color.Black,
                                    )
                                    Text(
                                        stringResource(R.string.vitamin_c_d_and_selen),
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 10.sp,
                                        color = AppColor,
                                    )
                                }
                                Spacer(modifier = Modifier.weight(1f))
                                Check()
                            }
                        }
                        Spacer(modifier = Modifier.height(15.dp))
                        Surface(
                            modifier = Modifier.fillMaxWidth()
                                .size(width = 391.dp, height = 80.dp)
                                .padding(start = 15.dp, end = 15.dp)
                                .background(color = colorResource(R.color.milk), shape = RoundedCornerShape(20)),
                            elevation = 2.dp
                        ) {
                            Row (modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                                verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start){
                                Column {
                                    Text(
                                        "10:12 AM",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 10.sp,
                                        color = Color.Black,
                                    )
                                    Text(
                                        stringResource(R.string.vitamin_c_d_and_selen),
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 10.sp,
                                        color = AppColor,
                                    )
                                }
                                Spacer(modifier = Modifier.weight(1f))
                                Check()
                            }
                        }
                        Spacer(modifier = Modifier.height(15.dp))
                        Surface(
                            modifier = Modifier.fillMaxWidth()
                                .size(width = 391.dp, height = 80.dp)
                                .padding(start = 15.dp, end = 15.dp)
                                .background(color = colorResource(R.color.milk), shape = RoundedCornerShape(20)),
                            elevation = 2.dp
                        ) {
                            Row (modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                                verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start){
                                Column {
                                    Text(
                                        "10:12 AM",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 10.sp,
                                        color = Color.Black,
                                    )
                                    Text(
                                        stringResource(R.string.vitamin_c_d_and_selen),
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 10.sp,
                                        color = AppColor,
                                    )
                                }
                                Spacer(modifier = Modifier.weight(1f))
                                Check()
                            }
                        }
                        Spacer(modifier = Modifier.height(15.dp))
                        Surface(
                            modifier = Modifier.fillMaxWidth()
                                .size(width = 391.dp, height = 80.dp)
                                .padding(start = 15.dp, end = 15.dp)
                                .background(color = colorResource(R.color.milk), shape = RoundedCornerShape(20)),
                            elevation = 2.dp

                        ) {
                            Row (modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                                verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start){
                                Column {
                                    Text(
                                        "10:12 AM",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 10.sp,
                                        color = Color.Black,
                                    )
                                    Text(
                                        stringResource(R.string.vitamin_c_d_and_selen),
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 10.sp,
                                        color = AppColor,
                                    )
                                }
                                Spacer(modifier = Modifier.weight(1f))
                                Check()
                            }
                        }
                        Spacer(modifier = Modifier.height(15.dp))
                        Surface(
                            modifier = Modifier.fillMaxWidth()
                                .size(width = 391.dp, height = 80.dp)
                                .padding(start = 15.dp, end = 15.dp)
                                .background(color = colorResource(R.color.milk), shape = RoundedCornerShape(20)),
                            elevation = 2.dp

                        ) {
                            Row (modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                                verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start){
                                Column {
                                    Text(
                                        "10:12 AM",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 10.sp,
                                        color = Color.Black,
                                    )
                                    Text(
                                        stringResource(R.string.vitamin_c_d_and_selen),
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 10.sp,
                                        color = AppColor,
                                    )
                                }
                                Spacer(modifier = Modifier.weight(1f))
                                Check()
                            }
                        }

                        }
                    }
