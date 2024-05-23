package com.example.vhh.ui.screen

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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
import com.example.vhh.ui.theme.AppColor
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun HomeScreen (navigator: DestinationsNavigator){
Column (
    modifier = Modifier
        .fillMaxSize()
        .background(color = MaterialTheme.colorScheme.background),
    verticalArrangement = Arrangement.Top,
    horizontalAlignment = Alignment.CenterHorizontally
){
Card (
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
            modifier = Modifier.clickable {  })
        Text(
            text = stringResource(id = R.string.menu),
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            color = Color.White,
            modifier = Modifier
                .paddingFromBaseline(top = 10.dp)
        )
        Image(painter = painterResource(id = R.drawable.bell), contentDescription = "", modifier
        = Modifier.clickable {  })
    }
}
    Spacer(modifier = Modifier.height(10.dp))
    Text(text = stringResource(id = R.string.please_select_your_required_service),
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        textAlign = TextAlign.Center,
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.padding(40.dp)
    )
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clickable { }
            .clip(RoundedCornerShape(CornerSize(40.dp)))
            .height(45.dp),
        backgroundColor = AppColor
    ){
Row (
    modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 20.dp),
    verticalAlignment = Alignment.CenterVertically,

){
Image(painter = painterResource(id = R.drawable.add), contentDescription = "")
    Text(text = stringResource(id = R.string.telemedicine_consultation),
        color = Color.White, textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(horizontal = 60.dp)

        )
}
    }
    Spacer(modifier = Modifier.height(10.dp))
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)

            .clip(RoundedCornerShape(CornerSize(40.dp)))
            .height(45.dp)
            .clickable { },
        backgroundColor = AppColor
    ){
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.Center

        ){
            Image(painter = painterResource(id = R.drawable.add), contentDescription = "")
            Text(text = stringResource(id = R.string.health_education_and_awareness),
                color = Color.White, textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 60.dp))
        }
    }
    Spacer(modifier = Modifier.height(10.dp))
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(CornerSize(40.dp)))
            .height(45.dp)
            .clickable { },
        backgroundColor = AppColor
    ){
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically,

        ){
            Image(painter = painterResource(id = R.drawable.add), contentDescription = "")
            Text(text = stringResource(id = R.string.medication),
                color = Color.White,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 60.dp))
        }
    }
    Spacer(modifier = Modifier.height(10.dp))
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(CornerSize(40.dp)))
            .height(45.dp)
            .clickable { },
        backgroundColor = AppColor
    ){
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically,

        ){
            Image(painter = painterResource(id = R.drawable.add), contentDescription = "")
            Text(text = stringResource(id = R.string.emergency_assistant),
                color = Color.White,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 50.dp))
        }
    }
    Spacer(modifier = Modifier.height(10.dp))
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(CornerSize(40.dp)))
            .height(45.dp)
            .clickable { },
        backgroundColor = AppColor
    ){
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically,

        ){
            Image(painter = painterResource(id = R.drawable.add), contentDescription = "")
            Text(text = stringResource(id = R.string.community),
                color = Color.White, textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 50.dp))
        }
    }
    Spacer(modifier = Modifier.height(10.dp))
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(CornerSize(40.dp)))
            .height(45.dp)
            .clickable { },
        backgroundColor = AppColor
    ){
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
        ){
            Image(painter = painterResource(id = R.drawable.add), contentDescription = "")
            Text(text = stringResource(id = R.string.first_aid),
                color = Color.White,  textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 100.dp)
            )
        }
    }

}
}