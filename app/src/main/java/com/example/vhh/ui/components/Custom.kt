package com.example.vhh.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.vhh.R
import com.example.vhh.ui.theme.AppColor

@Composable
fun Custom(
    onDismiss:()->Unit){
    Dialog(
        onDismissRequest = {
            onDismiss()
        },
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        )
    ) {
        Card (
//            elevation = 5.dp,
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .fillMaxWidth(0.95f)
        ){
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(modifier = Modifier,
                    contentAlignment = Alignment.Center
                ){
                    Surface(
                        modifier = Modifier
                            .size(100.dp),
                        shape = RoundedCornerShape(50),
                        color = AppColor.copy(0.5f)
                    ){
Image(painterResource(R.drawable.mark), contentDescription = null)
                    }
                }
                Text("Your Payment has been successful, you" +
                        "can have a consultation session with " +
                        "your trusted doctor",
                    fontWeight = FontWeight.Normal,
                    fontSize = 10.sp,
                    color = Color. Black
                )
                VhhButton(
                    modifier = Modifier,
                    text = "Go back home",
                ) {
                    onDismiss
                }
            }
        }
    }
}