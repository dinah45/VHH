package com.example.vhh.ui.telemedcine


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
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
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
import com.example.vhh.ui.components.VhhButton
import com.example.vhh.ui.theme.AppColor
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@ExperimentalComposeUiApi
@Destination
@Composable
fun Details (
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
                text = stringResource(id = R.string.doctor_details),
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 100.dp)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Image(painterResource(R.drawable.listen), contentDescription = null)
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Dr. Matthew",
                    fontWeight = FontWeight.ExtraBold,
                    color = AppColor,
                    fontSize = 25.sp
                )
                Spacer(modifier = Modifier.height(3.dp))
                Text(
                    stringResource(R.string.gynacologist),
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(3.dp))
                Row {
                    Card(
                        modifier = Modifier
                            .width(50.dp)
                            .height(15.dp)
                            .background(color = Color.Gray),
                        shape = RoundedCornerShape(30),
                        backgroundColor = Color.LightGray,
                    ) {
                        Row {
                            Icon(
                                Icons.Default.Star, contentDescription = null,
                                tint = AppColor
                            )
                            Text(
                                "4.5",
                                fontWeight = FontWeight.Bold,
                                color = AppColor,
                                fontSize = 13.sp
                            )
                        }
                    }
                    Spacer(modifier = Modifier.width(5.dp))
                    Image(painterResource(R.drawable.location), contentDescription = null)
                    Text(
                        "10.2km away",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        fontSize = 15.sp,
                        modifier = Modifier.padding(bottom = 15.dp)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            "About",
            fontWeight = FontWeight.ExtraBold,
            color = AppColor,
            fontSize = 25.sp,
            modifier = Modifier.padding(start = 15.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            "A gynecologist specializes in diagnosing and" +
                    " treating conditions of the female reproductive system.",
            fontWeight = FontWeight.Normal,
            color = Color.Black,
            fontSize = 16.sp,
            modifier = Modifier.padding(start = 15.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp)
                .width(4.dp),
            color = AppColor
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            "Choose Date",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 15.sp,
            modifier = Modifier.padding(start = 15.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(scrollState)
                .padding(start = 25.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Card(
                modifier = Modifier
                    .size(width = 55.dp, height = 55.dp),
                shape = RoundedCornerShape(30),
                backgroundColor = AppColor,
                contentColor = Color.White
            ) {
                Column {
                    Text(
                        "Mon",
                        fontWeight = FontWeight.Normal,
                        fontSize = 15.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(10.dp)
                    )
                    Text(
                        "01",
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.width(5.dp))
            Card(
                modifier = Modifier
                    .size(width = 55.dp, height = 55.dp),
                shape = RoundedCornerShape(30),
                backgroundColor = Color.LightGray,
            ) {
                Column {
                    Text(
                        "Tue",
                        fontWeight = FontWeight.Normal,
                        fontSize = 15.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(10.dp)
                    )
                    Text(
                        "02",
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.width(5.dp))
            Card(
                modifier = Modifier
                    .size(width = 55.dp, height = 55.dp),
                shape = RoundedCornerShape(30),
                backgroundColor = Color.LightGray,
            ) {
                Column {
                    Text(
                        "Wed",
                        fontWeight = FontWeight.Normal,
                        fontSize = 15.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(10.dp)
                    )
                    Text(
                        "03",
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.width(5.dp))
            Card(
                modifier = Modifier
                    .size(width = 55.dp, height = 55.dp),
                shape = RoundedCornerShape(30),
                backgroundColor = Color.LightGray,
            ) {
                Column {
                    Text(
                        "Thu",
                        fontWeight = FontWeight.Normal,
                        fontSize = 15.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(10.dp)
                    )
//    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        "04",
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.width(5.dp))
            Card(
                modifier = Modifier
                    .size(width = 55.dp, height = 55.dp),
                shape = RoundedCornerShape(30),
                backgroundColor = Color.LightGray,
            ) {
                Column {
                    Text(
                        "Fri",
                        fontWeight = FontWeight.Normal,
                        fontSize = 15.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(10.dp)
                    )
//    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        "05",
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.width(5.dp))
            Card(
                modifier = Modifier
                    .size(width = 55.dp, height = 55.dp),
                shape = RoundedCornerShape(30),
                backgroundColor = Color.LightGray,
            ) {
                Column {
                    Text(
                        "Sat",
                        fontWeight = FontWeight.Normal,
                        fontSize = 15.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(10.dp)
                    )
//    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        "06",
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.width(5.dp))
            Card(
                modifier = Modifier
                    .size(width = 55.dp, height = 55.dp),
                shape = RoundedCornerShape(30),
                backgroundColor = Color.LightGray,
            ) {
                Column {
                    Text(
                        "Sun",
                        fontWeight = FontWeight.Normal,
                        fontSize = 15.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(10.dp)
                    )
//    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        "07",
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp)
                .width(4.dp),
            color = AppColor
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            "Time ",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 15.sp,
            modifier = Modifier.padding(start = 15.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(scrollState)
                .padding(start = 25.dp, end = 25.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Card(
                modifier = Modifier
                    .size(width = 75.dp, height = 40.dp),
                shape = RoundedCornerShape(30),
                backgroundColor = Color.LightGray,
            ) {
                Text(
                    "8:00 am ",
                    fontWeight = FontWeight.Normal,
                    color = Color.Black,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Card(
                modifier = Modifier
                    .size(width = 75.dp, height = 40.dp),
                shape = RoundedCornerShape(30),
                backgroundColor = Color.LightGray,
            ) {
                Text(
                    "9:00 am ",
                    fontWeight = FontWeight.Normal,
                    color = Color.Black,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Card(
                modifier = Modifier
                    .size(width = 77.dp, height = 40.dp),
                shape = RoundedCornerShape(30),
                backgroundColor = Color.LightGray,
            ) {
                Text(
                    "10:00 am",
                    fontWeight = FontWeight.Normal,
                    color = Color.Black,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Card(
                modifier = Modifier
                    .size(width = 77.dp, height = 40.dp),
                shape = RoundedCornerShape(30),
                backgroundColor = Color.LightGray,
            ) {
                Text(
                    "11:00 am",
                    fontWeight = FontWeight.Normal,
                    color = Color.Black,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
 Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(scrollState)
                .padding(start = 25.dp, end = 25.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Card(
                modifier = Modifier
                    .size(width = 75.dp, height = 40.dp),
                shape = RoundedCornerShape(30),
                backgroundColor = AppColor,
            ) {
                Text(
                    "8:00 am ",
                    fontWeight = FontWeight.Normal,
                    color = Color.White,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Card(
                modifier = Modifier
                    .size(width = 75.dp, height = 40.dp),
                shape = RoundedCornerShape(30),
                backgroundColor = Color.LightGray,
            ) {
                Text(
                    "9:00 am ",
                    fontWeight = FontWeight.Normal,
                    color = Color.Black,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Card(
                modifier = Modifier
                    .size(width = 77.dp, height = 40.dp),
                shape = RoundedCornerShape(30),
                backgroundColor = Color.LightGray,
            ) {
                Text(
                    "10:00 am",
                    fontWeight = FontWeight.Normal,
                    color = Color.Black,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Card(
                modifier = Modifier
                    .size(width = 77.dp, height = 40.dp),
                shape = RoundedCornerShape(30),
                backgroundColor = Color.LightGray,
            ) {
                Text(
                    "11:00 am",
                    fontWeight = FontWeight.Normal,
                    color = Color.Black,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
 Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(scrollState)
                .padding(start = 25.dp, end = 25.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Card(
                modifier = Modifier
                    .size(width = 75.dp, height = 40.dp),
                shape = RoundedCornerShape(30),
                backgroundColor = Color.LightGray,
            ) {
                Text(
                    "8:00 am ",
                    fontWeight = FontWeight.Normal,
                    color = Color.Black,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Card(
                modifier = Modifier
                    .size(width = 75.dp, height = 40.dp),
                shape = RoundedCornerShape(30),
                backgroundColor = Color.LightGray,
            ) {
                Text(
                    "9:00 am ",
                    fontWeight = FontWeight.Normal,
                    color = Color.Black,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Card(
                modifier = Modifier
                    .size(width = 77.dp, height = 40.dp),
                shape = RoundedCornerShape(30),
                backgroundColor = Color.LightGray,
            ) {
                Text(
                    "10:00 am",
                    fontWeight = FontWeight.Normal,
                    color = Color.Black,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Card(
                modifier = Modifier
                    .size(width = 77.dp, height = 40.dp),
                shape = RoundedCornerShape(30),
                backgroundColor = Color.LightGray,
            ) {
                Text(
                    "11:00 am",
                    fontWeight = FontWeight.Normal,
                    color = Color.Black,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
 Spacer(modifier = Modifier.height(20.dp))
VhhButton(
    modifier = Modifier,
    text = "Book Appointment",
    processing = false,
    enabled = true,
    color = AppColor,
    contentColor = Color.White,
) { }

        }
    }

