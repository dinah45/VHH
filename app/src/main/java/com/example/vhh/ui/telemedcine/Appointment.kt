package com.example.vhh.ui.telemedcine

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
fun Appointment (
//   navigator: DestinationsNavigator
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
            "Date",
            fontWeight = FontWeight.Bold,
            color = AppColor,
            fontSize = 20.sp,
            modifier = Modifier.padding(start = 15.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp),
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
                fontWeight = FontWeight.Normal,
                color = Color.Black,
                fontSize = 13.sp,
                modifier = Modifier.padding(start = 15.dp)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp)
                .width(4.dp),
            color = AppColor
        )
        Spacer(modifier = Modifier.height(15.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                "Reason",
                fontWeight = FontWeight.Bold,
                color = AppColor,
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                "Charge",
                fontWeight = FontWeight.Normal,
                color = Color.Gray,
                fontSize = 10.sp
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            "Head ache",
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            fontSize = 16.sp,
            modifier = Modifier.padding(start = 15.dp)
        )
        Spacer(modifier = Modifier.height(15.dp))
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp)
                .width(4.dp),
            color = AppColor
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            "Payment Details",
            fontWeight = FontWeight.Bold,
            color = AppColor,
            fontSize = 18.sp,
            modifier = Modifier.padding(start = 15.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                "Consultation",
                fontWeight = FontWeight.Normal,
                color = Color.Black,
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                "#40,000",
                fontWeight = FontWeight.Normal,
                color = Color.Black,
                fontSize = 15.sp
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                "Admin Fee",
                fontWeight = FontWeight.Normal,
                color = Color.Black,
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                "#20,000",
                fontWeight = FontWeight.Normal,
                color = Color.Black,
                fontSize = 15.sp
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                "Additional Discount",
                fontWeight = FontWeight.Normal,
                color = Color.Black,
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                "#0",
                fontWeight = FontWeight.Normal,
                color = Color.Black,
                fontSize = 15.sp
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                "Total",
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                "#60,000",
                fontWeight = FontWeight.Bold,
                color = AppColor,
                fontSize = 15.sp
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp)
                .width(4.dp),
            color = AppColor
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            "Payment Method",
            fontWeight = FontWeight.Bold,
            color = AppColor,
            fontSize = 18.sp,
            modifier = Modifier.padding(start = 15.dp)
        )
        Spacer(modifier = Modifier.height(15.dp))
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .size(32.dp)
                .padding(horizontal = 16.dp)
                .clickable { },
            shape = RoundedCornerShape(40),
            color = Color(0xFF888888).copy(0.3f),
            contentColor = Color.Black
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 37.dp, vertical = 10.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.visa),
                    contentDescription = ""
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(text = stringResource(id = R.string.change),
                    fontWeight = FontWeight.Medium,
                    color = AppColor,
                    fontSize = 13.sp,
                    modifier = Modifier.padding(top = 15.dp)
                        .clickable { }
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 5.dp, end = 5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Surface(
                modifier = Modifier
                    .size(width = 130.dp, height = 70.dp)
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(25),
                color = Color(0xFF888888).copy(0.3f),
                contentColor = AppColor
            ) {
                Column (verticalArrangement = Arrangement.Center){
                    Text(
                        "Total",
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black,
                        fontSize = 20.sp
                    )
                    Text(
                        "#60,000",
                        fontWeight = FontWeight.Bold,
                        color = AppColor,
                        fontSize = 20.sp
                    )
                }
            }
Spacer(modifier = Modifier.weight(1f))
            Button(onClick = {
//                Custom(onDismiss = [onDiss])
            }, modifier = Modifier
                .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = AppColor,
                    contentColor = Color.White,
                    disabledBackgroundColor = AppColor.copy(0.7f)),
                shape = RoundedCornerShape(30)
            ) {
                Text("Booking",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.White)
            }
//            VhhButton(
//                modifier = Modifier,
//                text = "Booking",
//                processing = false,
//                enabled = true,
//                color = AppColor,
//                contentColor = Color.Black
//            ) {
//Custom(onDismiss = {} )
                 }
        }
    }
