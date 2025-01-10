//package com.example.vhh.ui.navigation
//
//
//
//import androidx.compose.ui.ExperimentalComposeUiApi
//import com.example.vhh.R
//import com.example.vhh.ui.destinations.BookingDestination
//import com.example.vhh.ui.destinations.ChatDestination
//import com.example.vhh.ui.destinations.HomeScreenDestination
//import com.example.vhh.ui.destinations.MedicationDestination
//import com.example.vhh.ui.destinations.ProfileDestination
//import com.ramcosta.composedestinations.spec.DirectionDestinationSpec
//
//enum class BottomNavScreen(
//    val direction: DirectionDestinationSpec,
//    val title: Int? = null,
//    val icon: Int? = null,
//
//    ) {
//    @OptIn(ExperimentalComposeUiApi::class)
//    HomeScreen(
//        direction = HomeScreenDestination,
//        title = R.string.home,
//        icon = R.drawable.home,
//    ),
//
//    @OptIn(ExperimentalComposeUiApi::class)
//    Booking(
//        direction = BookingDestination,
//        title = R.string.booking,
//        icon = R.drawable.calendar,
//    ),
//
//    @OptIn(ExperimentalComposeUiApi::class)
//    Medication(
//        direction = MedicationDestination,
//        title = R.string.menu,
//        icon = R.drawable.menu,
//    ),
//
//    @OptIn(ExperimentalComposeUiApi::class)
//    Chat(
//        direction = ChatDestination,
//        title = R.string.chat,
//        icon = R.drawable.sms,
//    ),
//
//    @OptIn(ExperimentalComposeUiApi::class)
//    Profile(
//        direction = ProfileDestination,
//        title = R.string.profile,
//        icon = R.drawable.user,
//    )
//}