package com.example.vhh.ui.screen

//import com.example.vhh.ui.destinations.WelcomeDestination
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.vhh.R
import com.example.vhh.ui.destinations.Onboard1Destination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.delay

@ExperimentalComposeUiApi
@Destination
@RootNavGraph(start = true)
@Composable
fun SplashScreen(navigator: DestinationsNavigator) {
    LaunchedEffect(key1 = Unit) {
        delay(2000)
        navigator.navigate(Onboard1Destination)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background), contentAlignment = Alignment.Center
    ) {
            Image(painter = painterResource(id = R.drawable.image43), contentDescription = "",
                modifier =  Modifier.background(color = MaterialTheme.colorScheme.background))
        }
    }