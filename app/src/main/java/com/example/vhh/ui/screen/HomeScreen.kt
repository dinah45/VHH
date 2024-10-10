package com.example.vhh.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.ScrollableDefaults
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
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
import com.example.vhh.ui.destinations.HealthEducationDestination
import com.example.vhh.ui.destinations.MedicationDestination
import com.example.vhh.ui.destinations.PharmacyDestination
//import com.example.vhh.ui.navigation.BottomNav
import com.example.vhh.ui.theme.AppColor
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

//
//@Composable
//fun MyCard() {
//    Card(
//        modifier = Modifier
//            .size(150.dp)
//            .padding(10.dp)
//            .background(color = colorResource(R.color.green_app),
//                shape = RoundedCornerShape(20)),
//        elevation = 1.dp){
//
//    }
//}

@ExperimentalComposeUiApi
@Destination
@Composable
fun HomeScreen (
//fun HomeScreen (navigator: DestinationsNavigator
) {
    val scrollState = rememberScrollState()
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
                    text = stringResource(id = R.string.menu),
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
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Center
        ) {
            Surface(
                modifier = Modifier.size(width = 180.dp, height = 140.dp)
                    .clickable {

                    },
                color = colorResource(R.color.green_app),
                shape = RoundedCornerShape(20),
                contentColor = Color.Black,
                elevation = 1.dp
            ) {
                Text(
                    stringResource(R.string.telemedicine_consultation),
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(vertical = 50.dp)
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Surface(
                modifier = Modifier.size(width = 180.dp, height = 140.dp)
                    .clickable {
//                        navigator.navigate(MedicationDestination)
                    },
                color = colorResource(R.color.green_app),
                shape = RoundedCornerShape(20),
                contentColor = Color.Black,
                elevation = 1.dp
            ) {
                Text(
                    stringResource(R.string.medication),
                    fontWeight = FontWeight.Medium,
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(vertical = 50.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Center
        ) {
        Surface(
                modifier = Modifier.size(width = 180.dp, height = 140.dp)
                    .clickable {
//                            navigator.navigate(MedicationDestination)
                    },
                color = colorResource(R.color.green_app),
                shape = RoundedCornerShape(20),
                contentColor = Color.Black,
                elevation = 1.dp
            ) {
                Text(
                    stringResource(R.string.health_tracking),
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(vertical = 50.dp)
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Surface(
                modifier = Modifier.size(width = 180.dp, height = 140.dp)
                    .clickable {
//                            navigator.navigate(HealthEducationDestination)
                    },
                color = colorResource(R.color.green_app),
                shape = RoundedCornerShape(20),
                contentColor = Color.Black,
                elevation = 1.dp
            ) {
                Text(
                    stringResource(R.string.health_education_and_awareness),
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(vertical = 50.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Center
        ) {
                Surface(
                    modifier = Modifier.size(width = 180.dp, height = 140.dp)
                        .clickable {
//                            navigator.navigate(PharmacyDestination)
                        },
                    color = colorResource(R.color.green_app),
                    shape = RoundedCornerShape(20),
                    contentColor = Color.Black,
                    elevation = 1.dp
                ) {
                    Text(
                        stringResource(R.string.pharmacy),
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(vertical = 50.dp)
                    )
                }
            Spacer(modifier = Modifier.width(10.dp))
                Surface(
                    modifier = Modifier.size(width = 180.dp, height = 140.dp)
                        .clickable {

                        },
                    color = colorResource(R.color.green_app),
                    shape = RoundedCornerShape(20),
                    contentColor = Color.Black,
                    elevation = 1.dp
                ) {
                    Text(
                        stringResource(R.string.first_aid),
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(vertical = 50.dp)
                    )
                }
            }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Center
        ) {
                Surface(
                    modifier = Modifier.size(width = 180.dp, height = 140.dp)
                        .clickable {

                        },
                    color = colorResource(R.color.green_app),
                    shape = RoundedCornerShape(20),
                    contentColor = Color.Black,
                    elevation = 1.dp
                ) {
                    Text(
                        stringResource(R.string.community),
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(vertical = 50.dp)
                    )
                }
            Spacer(modifier = Modifier.width(10.dp))
                Surface(
                    modifier = Modifier.size(width = 180.dp, height = 140.dp)
                        .clickable {

                        },
                    color = colorResource(R.color.green_app),
                    shape = RoundedCornerShape(20),
                    contentColor = Color.Black,
                    elevation = 1.dp
                ) {
                    Text(
                        text = stringResource(R.string.emergency_assistant),
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(vertical = 60.dp)
                    )
                }
            }
        }
    }
