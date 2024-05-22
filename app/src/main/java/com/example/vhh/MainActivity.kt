package com.example.vhh

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.vhh.ui.auth.Login
import com.example.vhh.ui.auth.Start
import com.example.vhh.ui.components.VhhButton
import com.example.vhh.ui.screen.SplashScreen
import com.example.vhh.ui.screen.Welcome
import com.example.vhh.ui.onboarding.Onboard1
import com.example.vhh.ui.onboarding.Onboard2
import com.example.vhh.ui.theme.VHHTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VHHTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                 Login()
                }
            }
        }
    }
}
//
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    VHHTheme {
//        Greeting("Android")
//    }
//}