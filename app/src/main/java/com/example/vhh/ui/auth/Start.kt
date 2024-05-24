package com.example.vhh.ui.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vhh.R
import com.example.vhh.ui.components.VhhButton
import com.example.vhh.ui.components.VhhButton1
import com.example.vhh.ui.destinations.LoginDestination
import com.example.vhh.ui.destinations.SignUpDestination
import com.example.vhh.ui.theme.AppColor
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@ExperimentalComposeUiApi
@Destination
@Composable
fun Start(navigator: DestinationsNavigator){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
Text(text = stringResource(id = R.string.welcome_to),
    fontSize = 18.sp,
    fontWeight = FontWeight.Bold,
    color = AppColor)

        Image(painter = painterResource(id = R.drawable.image43), contentDescription = "",
            modifier =  Modifier.background(color = MaterialTheme.colorScheme.background))

        Text(text = stringResource(id = R.string.lets_get_started),
            fontSize = 20.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color.Black
        )

        VhhButton(onClick = {
            navigator.navigate(LoginDestination)
        }, text = stringResource(id = R.string.login))
        Spacer(modifier = Modifier.height(10.dp))

        VhhButton1(onClick = {
            navigator.navigate(SignUpDestination)
        }, text = stringResource(id = R.string.sign_up))
    }
}