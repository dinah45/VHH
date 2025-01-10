package com.example.vhh.ui.auth

import android.app.Activity
import android.widget.Toast
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vhh.R
import com.example.vhh.ui.components.VhhButton
import com.example.vhh.ui.components.VhhInputField
//import com.example.vhh.ui.destinations.HomeScreenDestination
import com.example.vhh.ui.destinations.LoginDestination
import com.example.vhh.ui.destinations.OtpScreenDestination
import com.example.vhh.ui.theme.AppColor
import com.example.vhh.ui.utill.Toaster
import com.example.vhh.ui.utill.getCurrentLocation
import com.example.vhh.ui.utill.locationModels.LocationResult
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.delay
import org.koin.androidx.compose.koinViewModel
import timber.log.Timber

@ExperimentalComposeUiApi
@Destination
@Composable
//fun SignUp() {
fun SignUp(navigator: DestinationsNavigator) {
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var phoneNumber by remember { mutableStateOf(TextFieldValue("")) }
    var gender by remember { mutableStateOf(TextFieldValue("")) }
    var firstName by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var lastName by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var location by remember {
        mutableStateOf<LocationResult?>(null)
    }
    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current
    var password by remember { mutableStateOf(TextFieldValue("")) }
    var processing by remember {
        mutableStateOf(false)
    }

    var isError by remember {
        mutableStateOf(false)
    }
    var message by remember {
        mutableStateOf("")
    }
    val emailRegex = Regex(pattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")

    //to check if the email is valid
    var isEmailValid by remember {
        mutableStateOf(true)
    }
    val viewModel: AuthViewModel = koinViewModel()

    var address by remember {
        mutableStateOf(TextFieldValue(""))
    }
    val activity = context as Activity

    var referralCode by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var isChecked by remember {
        mutableStateOf(
            false
        )
    }
    val currentLocation = activity.getCurrentLocation()

//    LaunchedEffect(name.text) {
//        if (name.text.isNotBlank()) {
//            delay(500L)
//            viewModel.checkUserName(name.text)
//                .addOnSuccessListener { isFree ->
//                    Timber.d("Username availability: ${isFree.name}")
////                    isNameTaken = !isFree.username.equals(userName.text, ignoreCase = true)
//                    isNameTaken = true
//                }
//                .addOnFailureListener { exception ->
//                    Timber.d("Username check failed: $exception")
//                    isUsernameTaken = false // Assume taken if check fails
//                }
//        }
//    }
    val canProceed = firstName.text.isNotBlank() &&
            lastName.text.isNotBlank() &&
            address.text.isNotBlank() &&
            password.text.isNotBlank() && isChecked

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 20.dp)
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = stringResource(id = R.string.hello),
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = AppColor
        )
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = stringResource(id = R.string.sign_up),
            style = MaterialTheme.typography.headlineLarge,
            color = AppColor
        )
                    Spacer(modifier = Modifier.height(40.dp))
        VhhInputField(
            value = firstName,
            onValueChange = { firstName = it.copy(text = it.text.trim()) },
            placeholder = stringResource(id = R.string.firstName),
            keyboardType = KeyboardType.Text,
        )
        Spacer(modifier = Modifier.height(10.dp))
        VhhInputField(
            value = lastName,
            onValueChange = { lastName = it.copy(text = it.text.trim()) },
            placeholder = stringResource(id = R.string.LastName),
            keyboardType = KeyboardType.Text,
        )
        Spacer(modifier = Modifier.height(10.dp))
        VhhInputField(
            value = email,
            onValueChange = { email = it.copy(text = it.text.trim())},
            placeholder = stringResource(id = R.string.email),
            keyboardType = KeyboardType.Email,
            isError = !isEmailValid)
        if (!isEmailValid) {
            Text(
                text = "please_enter_a_valid_email",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Red
            )
        }
        //show error if email is not valid
        if (isError) {
            Text(
                text = message,
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Red
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        VhhInputField(
            value = phoneNumber,
            onValueChange = {
                isError = false
                phoneNumber = it
            },
            placeholder = stringResource(id = R.string.phone_number),
            keyboardType = KeyboardType.Number,
            isError = isError,
        )
        //show error if email is not valid
        if (isError) {
            Text(
                text = message,
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Red
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        VhhInputField(
            value = gender,
            onValueChange = { gender = it.copy(text = it.text.trim()) },
            placeholder = stringResource(id = R.string.gender),
            keyboardType = KeyboardType.Text,
        )

        Spacer(modifier = Modifier.height(10.dp))
        VhhInputField(
            value = address,
            onValueChange = { address = it.copy(text = it.text.trim()) },
            placeholder = stringResource(id = R.string.address_City_State),
            keyboardType = KeyboardType.Text,
            isAddress = true,
            isEditable = false,
            location = currentLocation,
            onLocationClick = {
                location = it
            }
        )
        Spacer(modifier = Modifier.height(10.dp))
        VhhInputField(
            value = password,
            onValueChange = { password = it.copy(text = it.text.trim()) },
            placeholder = stringResource(id = R.string.password),
            keyboardType = KeyboardType.Password,
        )
        Spacer(modifier = Modifier.height(50.dp))
        VhhButton(
            Modifier.fillMaxWidth(),
            processing = processing,
            enabled = canProceed,
            text = stringResource(id = R.string.create_Account)
        ) {

            // check if the email is valid
            processing = true
            viewModel.signUp(
                email = email.toString(),
                password = password.text,
                firstName = firstName.text,
                lastName = lastName.text,
                address = address.text,
                location = location!!
            ).addOnSuccessListener { resp ->
                processing = false
                if (resp.token.isNotEmpty()) {
                    viewModel.saveToken(resp.token)
                }
                Timber.d(resp.toString())
                //navigate to home screen
                navigator.navigate(
                    OtpScreenDestination(
                        email = email.toString(),
                        isNewDevice = false,
                        isSignUp = true
                    )
                ) {
                    launchSingleTop = true
                }
            }.addOnFailureListener { exception ->
                //show toast
                Toaster(
                    context = context,
                    message = exception,
                    image = R.drawable.logo
                ).show()
                processing = false
                Timber.d(exception)
            }

        }
        Spacer(modifier = Modifier.height(40.dp))

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .size(40.dp)
                .clickable { },
            shape = RoundedCornerShape(40),
            color = Color(0xFF888888).copy(0.3f),
            contentColor = Color.Black
        ) {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 37.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ){
Image(painter = painterResource(id = R.drawable.google), contentDescription = "")
                Text(text = stringResource(id = R.string.continue_with_google),
                  fontWeight =  FontWeight.Medium,
                    color = Color.Black,
                    fontSize = 13.sp,
                    modifier = Modifier.padding(start = 15.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .size(40.dp)
                .clickable { },
            shape = RoundedCornerShape(40),
            color = Color(0xFF888888).copy(0.3f),
            contentColor = Color.Black
        ) {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 37.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ){
Image(painter = painterResource(id = R.drawable.apple), contentDescription = "")
                Text(text =
    stringResource(id = R.string.continue_with_apple),
                  fontWeight =  FontWeight.Medium,
                    color = Color.Black,
                    fontSize = 13.sp,
                    modifier = Modifier.padding(start = 15.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(30.dp))
        Row (modifier = Modifier.padding(start= 90.dp)){
            Text(
                text = stringResource(id = R.string.already_have_an_account),
                fontSize = 13.sp
            )
            Text(
                text = stringResource(id = R.string.login),
                fontSize = 13.sp,
                color = AppColor,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable {
//                    navigator.navigate(LoginDestination())
                }
            )
        }
    }
}