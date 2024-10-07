package com.example.vhh.ui.auth

import androidx.compose.ui.unit.dp
import com.example.vhh.R
import com.example.vhh.ui.components.VhhButton
import com.example.vhh.ui.components.VhhInputField
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import com.example.vhh.ui.utill.Toaster
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import org.koin.androidx.compose.koinViewModel
import timber.log.Timber


@ExperimentalComposeUiApi
@Destination
@Composable
fun ForgetPassword(mail: String, navigator: DestinationsNavigator) {
    val viewModel: AuthViewModel = koinViewModel()
    var email by remember {
        mutableStateOf(TextFieldValue(mail))
    }
    //email regex
    val emailRegex = Regex(pattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")

    //to check if the email is valid
    var isEmailValid by remember {
        mutableStateOf(true)
    }
    var processing by remember {
        mutableStateOf(false)
    }
    val context = LocalContext.current
    Column(
        Modifier
            .padding(vertical = 30.dp, horizontal = 16.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Image(
            painter = painterResource(id = R.drawable.arrow),
            contentDescription = "Arrow Back",

            modifier = Modifier
                .clickable {
                    navigator.popBackStack()
                }
                .size(24.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Cakkie Logo",
            modifier = Modifier
                .padding(bottom = 30.dp)
                .size(160.dp)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = stringResource(id = R.string.forget_password),
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = stringResource(id = R.string.no_worries),
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(40.dp))
        VhhInputField(
            value = email,
            onValueChange = { email = it },
            placeholder = stringResource(id = R.string.email),
            keyboardType = KeyboardType.Email,
            isError = !isEmailValid
        )
        //show error if email is not valid
        if (!isEmailValid) {
            Text(
                text = stringResource(id = R.string.please_enter_a_valid_email),
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Red
            )
        }
        Spacer(modifier = Modifier.weight(0.3f))
        VhhButton (
            Modifier.fillMaxWidth(),
            processing = processing,
            enabled = email.text.isNotEmpty(),
            text = "submit"
        ) {
            //check if the email is valid
            isEmailValid = emailRegex.matches(input = email.text)
            if (isEmailValid) {
                processing = true
                viewModel.forgetPassword(email.text).addOnSuccessListener { response ->
                    processing = false
                    //  show toast
                    Toaster(
                        context = context,
                        message = response.message,
                        image = R.drawable.logo
                    ).show()
                    //    navigate to otp screen
                    navigator.navigate(
                        Otp

//                        (
//                            email = email.text,
//                            isNewDevice = false
//                        )
                    )
                }.addOnFailureListener { exception ->
                    //  show toast
                    Toaster(
                        context = context,
                        message = exception,
                        image = R.drawable.logo
                    ).show()
                    processing = false
                    Timber.d(exception)
                }
            }
        }
    }
}