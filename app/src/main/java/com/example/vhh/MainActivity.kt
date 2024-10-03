package com.example.vhh

//import com.example.vhh.ui.screen.Welcome
//import com.example.vhh.ui.screens.NavGraphs
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Scaffold
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.Navigator
import com.example.vhh.ui.NavGraphs
import com.example.vhh.ui.auth.Login
import com.example.vhh.ui.auth.SignUp
import com.example.vhh.ui.components.PageTab
import com.example.vhh.ui.navigation.BottomNavScreen
import com.example.vhh.ui.screen.HomeScreen
import com.example.vhh.ui.telemedcine.Appointment
import com.example.vhh.ui.telemedcine.Booking
import com.example.vhh.ui.telemedcine.Details
import com.example.vhh.ui.telemedcine.Notifications
import com.example.vhh.ui.telemedcine.Profile
import com.example.vhh.ui.telemedcine.Video
import com.example.vhh.ui.telemedcine.Video1
import com.example.vhh.ui.theme.VHHTheme
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.animations.rememberAnimatedNavHostEngine
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@ExperimentalComposeUiApi
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterialNavigationApi::class, ExperimentalAnimationApi::class,
        ExperimentalFoundationApi::class
    )
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VHHTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    HomeScreen(
                    )
//                    DestinationsNavHost(navGraph = NavGraphs.root,
//                        engine = rememberAnimatedNavHostEngine()
//                    )
                }
            }
        }
    }
}
//
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(na
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