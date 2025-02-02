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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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

@OptIn(ExperimentalMaterialApi::class)
@ExperimentalComposeUiApi
@Destination
@Composable
fun Booking (
   navigator: DestinationsNavigator
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(color = MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
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
                text = stringResource(id = R.string.appointment),
                fontWeight = FontWeight.Medium,
                fontSize = 25.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 100.dp)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
//        TabRow(modifier = Modifier, selectedTabIndex = 1,
//            backgroundColor = Color(0xFF888888).copy(0.3f),
//            contentColor = Color.White, indicator = , tabs = {}
//        ) { }
        Surface(
            modifier = Modifier.fillMaxWidth().padding(10.dp).height(45.dp),
//            elevation = 3.dp,
            color = AppColor.copy(0.05f),
            shape = RoundedCornerShape(30.dp)
        ) {
            Row(
                modifier = Modifier.padding(5.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Upcoming", fontWeight = FontWeight.Medium, fontSize = 16.sp)
                Text("Completed", fontWeight = FontWeight.Medium, fontSize = 16.sp)
                Text("Cancelled", fontWeight = FontWeight.Medium, fontSize = 16.sp)
            }
        }
        Surface(
            modifier = Modifier.fillMaxWidth().padding(10.dp).height(150.dp),
            color = AppColor.copy(0.05f),
            shape = RoundedCornerShape(20.dp)
        ) {
                Row {
                    Surface(
                        modifier = Modifier.size(100.dp).padding(10.dp),
                        shape = RoundedCornerShape(50)
                    ) {
                        Image(
                            painterResource(R.drawable.listen), contentDescription = null,
                            contentScale = ContentScale.FillBounds
                        )
                    }
                    Column {
                        Text(
                            "Dr. Matthew",
                            fontWeight = FontWeight.ExtraBold,
                            color = AppColor,
                            fontSize = 20.sp
                        )
                        Spacer(modifier = Modifier.height(3.dp))
                        Text(
                            stringResource(R.string.gynacologist),
                            fontWeight = FontWeight.Bold,
                            color = Color.Gray,
                            fontSize = 16.sp
                        )
                        Row(
                            modifier = Modifier
                                .padding(end=15.dp)
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Icon(
                                Icons.Default.DateRange,
                                contentDescription = null,
                                modifier = Modifier, tint = AppColor
                            )
                            Text(
                                "Monday, 01 June 2024 [12:00 pm]",
                                fontWeight = FontWeight.Medium,
                                color = Color.Black,
                                fontSize = 13.sp,
                            )
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                        Row(
                            modifier = Modifier,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Surface(
                                modifier = Modifier.width(130.dp).height(35.dp)
                                    .clickable { },
//            elevation = 3.dp,
                                color = Color.LightGray.copy(0.5f),
                                shape = RoundedCornerShape(30.dp)
                            ) {
                                Text(
                                    "Cancel",
                                    fontWeight = FontWeight.Medium,
                                    color = Color.Black,
                                    fontSize = 15.sp,
                                    modifier = Modifier.padding(start = 30.dp, end = 10.dp, top = 7.dp)
                                    )
                            }
                            Spacer(modifier = Modifier.weight(1f))
                            Surface(
                                modifier = Modifier.width(130.dp).height(35.dp)
                                    .clickable { },
//            elevation = 3.dp,
                                color = AppColor,
                                shape = RoundedCornerShape(30.dp)
                            ) {
                                Text(
                                    "Reschedule",
                                    fontWeight = FontWeight.Medium,
                                    color = Color.White,
                                    fontSize = 15.sp,
                                    modifier = Modifier.padding(start = 20.dp, end = 10.dp, top = 7.dp)
                                )
                            }
                        }
                    }
                }
            }
        Spacer(modifier = Modifier.height(15.dp))
  Surface(
            modifier = Modifier.fillMaxWidth().padding(10.dp).height(150.dp),
            color = AppColor.copy(0.05f),
            shape = RoundedCornerShape(20.dp)
        ) {
                Row {
                    Surface(
                        modifier = Modifier.size(100.dp).padding(10.dp),
                        shape = RoundedCornerShape(50)
                    ) {
                        Image(
                            painterResource(R.drawable.listen), contentDescription = null,
                            contentScale = ContentScale.FillBounds
                        )
                    }
                    Column {
                        Text(
                            "Dr. Matthew",
                            fontWeight = FontWeight.ExtraBold,
                            color = AppColor,
                            fontSize = 20.sp
                        )
                        Spacer(modifier = Modifier.height(3.dp))
                        Text(
                            stringResource(R.string.gynacologist),
                            fontWeight = FontWeight.Bold,
                            color = Color.Gray,
                            fontSize = 16.sp
                        )
                        Row(
                            modifier = Modifier
                                .padding(end=15.dp)
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Icon(
                                Icons.Default.DateRange,
                                contentDescription = null,
                                modifier = Modifier, tint = AppColor
                            )
                            Text(
                                "Monday, 01 June 2024 [12:00 pm]",
                                fontWeight = FontWeight.Medium,
                                color = Color.Black,
                                fontSize = 13.sp,
                            )
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                        Row(
                            modifier = Modifier,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Surface(
                                modifier = Modifier.width(130.dp).height(35.dp)
                                    .clickable { },
//            elevation = 3.dp,
                                color = Color.LightGray.copy(0.5f),
                                shape = RoundedCornerShape(30.dp)
                            ) {
                                Text(
                                    "Cancel",
                                    fontWeight = FontWeight.Medium,
                                    color = Color.Black,
                                    fontSize = 15.sp,
                                    modifier = Modifier.padding(start = 30.dp, end = 10.dp, top = 7.dp)
                                    )
                            }
                            Spacer(modifier = Modifier.weight(1f))
                            Surface(
                                modifier = Modifier.width(130.dp).height(35.dp)
                                    .clickable { },
//            elevation = 3.dp,
                                color = AppColor,
                                shape = RoundedCornerShape(30.dp)
                            ) {
                                Text(
                                    "Reschedule",
                                    fontWeight = FontWeight.Medium,
                                    color = Color.White,
                                    fontSize = 15.sp,
                                    modifier = Modifier.padding(start = 20.dp, end = 10.dp, top = 7.dp)
                                )
                            }
                        }
                    }
                }
            }





    }
}

