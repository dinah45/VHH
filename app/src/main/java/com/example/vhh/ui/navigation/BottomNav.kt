package com.example.vhh.ui.navigation

import com.example.vhh.ui.NavGraphs
import com.example.vhh.ui.appCurrentDestinationAsState
//import com.example.vhh.ui.SplahScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Recomposer
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder
import com.example.vhh.R
import com.example.vhh.ui.destinations.ChatDestination
import com.example.vhh.ui.destinations.HomeScreenDestination
import com.example.vhh.ui.destinations.TypedDestination
import com.example.vhh.ui.startAppDestination
import com.example.vhh.ui.theme.AppColor
//import com.vhh.ui.theme.Inactive
import com.ramcosta.composedestinations.navigation.navigate

import com.ramcosta.composedestinations.navigation.navigate


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun BottomNav(
    navController: NavHostController,
    state: Boolean,
    modifier: Modifier = Modifier,
) {
//     list screens to show in bottom nav
    val screens = listOf(
        BottomNavScreen.HomeScreen,
        BottomNavScreen.Booking,
        BottomNavScreen.Medication,
        BottomNavScreen.Chat,
        BottomNavScreen.Profile
    )

    AnimatedVisibility(
        visible = state,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it }),
        modifier = modifier
    ) {
        //            val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination: TypedDestination<*> =
            navController.appCurrentDestinationAsState().value
                ?: NavGraphs.root.startAppDestination

        Card(
            modifier = Modifier
                .shadow(80.dp)
                .fillMaxWidth(),
            backgroundColor = Color.Transparent,
            elevation = 50.dp
        ) {
            Box(
                modifier = modifier
                    .background(Color.Transparent)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = modifier
                        .align(Alignment.BottomCenter)
                        .background(Color.White)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom
                ) {

                    screens.forEach { screen ->
                        if (screen == BottomNavScreen.Medication) {
                            Spacer(modifier = Modifier.width(90.dp))
                        } else {
                            Column(
                                Modifier
                                    .padding(
                                        start = if (screen.direction == HomeScreenDestination) 10.dp else 0.dp,
                                        end = if (screen.direction == ChatDestination) 10.dp else 0.dp
                                    )
                                    .background(Color.Transparent)
                                    .clickable {
                                        navController.navigate(
                                            screen.direction,
                                            fun NavOptionsBuilder.() {
                                                launchSingleTop = true
                                            })
                                    },
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.mark),
                                    contentDescription = null,
                                    tint = if (currentDestination == screen.direction) AppColor else Color.Transparent,
                                    modifier = Modifier
                                        .height(3.dp)
                                        .width(38.dp),
                                )
                                Spacer(modifier = Modifier.height(7.dp))
                                Icon(
                                    painter = painterResource(screen.icon!!),
                                    contentDescription = stringResource(id = screen.title!!),
                                    tint = if (currentDestination == screen.direction) AppColor else Color.Gray,
                                    modifier = Modifier
                                        .height(24.dp)
                                        .width(24.dp)
                                        .padding(bottom = 5.dp),
                                )
                                Text(
                                    text = stringResource(id = screen.title),
                                    fontSize = 12.sp,
                                    style = MaterialTheme.typography.body1,
                                    color = if (currentDestination == screen.direction) AppColor else Color.Black,
                                    modifier = Modifier.padding(bottom = 15.dp)
                                )
                            }
                        }
                    }
                }

                Box(
                    Modifier
                        .clip(CircleShape)
                        .background(AppColor),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        Modifier
                            .padding(top = 15.dp, start = 15.dp, end = 15.dp)
                            .clickable {
                                navController.navigate(
                                    screens.find { it.title == R.string.menu }!!.direction,
                                    fun NavOptionsBuilder.() {
                                        launchSingleTop = true
                                    })
                            },
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(
                            Modifier
                                .clip(CircleShape)
                                .background(AppColor)
                                .size(60.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painter = painterResource(screens.find { it.title == R.string.menu }!!.icon!!),
                                contentDescription = stringResource(id = screens.find { it.title == R.string.menu }!!.title!!),
                                tint = AppColor,
                                modifier = Modifier
                                    .size(24.dp)
                            )
                        }
                        Text(
                            text = stringResource(id = screens.find { it.title == R.string.menu }!!.title!!),
                            fontSize = 12.sp,
                            style = MaterialTheme.typography.body1,
                            color = if (currentDestination == screens.find { it.title == R.string.menu }!!
                                    .direction
                            ) AppColor else Color.Black,
                            modifier = Modifier.padding(bottom = 15.dp)
                        )
                    }
                }
            }
        }
    }
}