package com.example.vhh.ui.settings

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vhh.R
import com.example.vhh.ui.components.VhhButton
import com.example.vhh.ui.destinations.HomeScreenDestination
import com.example.vhh.ui.theme.AppColor
import com.example.vhh.ui.utill.Toaster
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.popUpTo
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalComposeUiApi::class)
@Destination
@Composable
fun ReactivateAccount(navigator: DestinationsNavigator) {
    val viewModel: SettingsViewModel = koinViewModel()
    val context = LocalContext.current
    var processing by remember {
        mutableStateOf(false)
    }
    Column(Modifier.padding(horizontal = 16.dp)) {
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = stringResource(
                    id = R.string.vhh_logo
                ),
                modifier = Modifier
                    .size(27.dp),
                contentScale = ContentScale.FillWidth
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = stringResource(id = R.string.account),
                style = MaterialTheme.typography.bodyLarge,
                fontSize = 16.sp,
                color = AppColor,
                fontWeight = FontWeight.SemiBold
            )
        }
        Spacer(modifier = Modifier.height(80.dp))
        Column(
            Modifier
                .fillMaxHeight(0.7f)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
//            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.reactivate),
                contentDescription = "under construction",
                modifier = Modifier
                    .size(250.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(28.dp))

            Text(
                text = stringResource(id = R.string.reactivate_account),
                style = MaterialTheme.typography.titleLarge,
            )
            Text(
                text = stringResource(id = R.string.we_are_glad),
                style = MaterialTheme.typography.bodyLarge,
            )
        }
        Spacer(modifier = Modifier.fillMaxHeight(0.2f))
        VhhButton (
            text = stringResource(id = R.string.reactivate_account),
            modifier = Modifier.fillMaxWidth(),
            processing = processing,
        ) {
            processing = true
            viewModel.reactivateAccount {
                processing = false
                if (it) {
                    navigator.navigate(HomeScreenDestination) {
                        popUpTo(ReactivateAccountDestination) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                } else {
                    Toaster(
                        context = context,
                        message = "Failed to reactivate account, please contact support!",
                        image = R.drawable.logo
                    ).show()
                }
            }
        }
    }
}
