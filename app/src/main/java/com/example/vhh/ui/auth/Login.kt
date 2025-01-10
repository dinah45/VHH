package com.example.vhh.ui.auth

//import com.example.vhh.ui.destinations.OptIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
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
import com.example.vhh.ui.destinations.ForgotPasswordDestination
import com.example.vhh.ui.destinations.HomeScreenDestination
//import com.example.vhh.ui.destinations.HomeScreenDestination
import com.example.vhh.ui.destinations.LoginDestination
import com.example.vhh.ui.destinations.OtpScreenDestination
import com.example.vhh.ui.destinations.SignUpDestination
import com.example.vhh.ui.theme.AppColor
import com.example.vhh.ui.utill.Toaster
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import org.koin.androidx.compose.koinViewModel

@ExperimentalComposeUiApi
@Destination
@Composable
//fun Login() {
fun Login(email: String,
          navigator: DestinationsNavigator) {
    val context = LocalContext.current
    val viewModel: AuthViewModel = koinViewModel()
    val keyboardController = LocalSoftwareKeyboardController.current
    var email by remember { mutableStateOf(TextFieldValue("")) }
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
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 20.dp)
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Spacer(modifier = Modifier.height(70.dp))
        Text(
            text = stringResource(id = R.string.hello_there),
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = AppColor,
        )
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = stringResource(id = R.string.login),
            style = MaterialTheme.typography.headlineLarge,
            color = AppColor,
        )
        Spacer(modifier = Modifier.height(40.dp))
        VhhInputField(
            value = email,
            onValueChange = { email = it.copy(text = it.text.trim()) },
            placeholder = stringResource(id = R.string.email),
            keyboardType = KeyboardType.Email,
            isError = !isEmailValid
        )
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
            value = password,
            onValueChange = { password = it.copy(text = it.text.trim()) },
            placeholder = stringResource(id = R.string.password),
            keyboardType = KeyboardType.Password,
        )
        Text(
            stringResource(R.string.forget_password),
            fontWeight = FontWeight.Normal,
//                fontSize = 13.dp,
            color = AppColor,
            modifier = Modifier.align(Alignment.End)
                .clickable {
                    navigator.navigate(ForgotPasswordDestination(email = ""))
                }
        )
        Spacer(modifier = Modifier.height(30.dp))
        VhhButton(
            Modifier.fillMaxWidth(),
            processing = processing,
            text = stringResource(id = R.string.login),
            enabled = password.text.isNotEmpty()
        ) {
            processing = true
            viewModel.login(email.toString(), password.text)
                .addOnSuccessListener {
                    processing = false
                    if (it.token.isNotEmpty()) {
                        viewModel.saveToken(it.token)
                        viewModel.saveUser(it.user)
                    }
                    if (it.isNewDevice) {
                        Toaster(
                            context = context,
                            message = it.message,
                            image = R.drawable.logo
                        ).show()
                        navigator.navigate(OtpScreenDestination(email = email.toString(), isNewDevice = true))
                    } else if (it.token.isEmpty()) {
                        Toaster(
                            context = context,
                            message = it.message,
                            image = R.drawable.logo
                        ).show()
                        navigator.navigate(
                            OtpScreenDestination(
                                email = email.toString(),
                                isNewDevice = false,
                                isSignUp = true
                            )
                        )
                    } else {
                        Toaster(
                            context = context,
                            message = "Login Success",
                            image = R.drawable.logo
                        ).show()
                        navigator.navigate(HomeScreenDestination) {
                            popUpTo(LoginDestination.route) {
                                inclusive = true
                            }
                            popUpTo(SignUpDestination.route) {
                                inclusive = true
                            }
                            launchSingleTop = true
                        }
                    }

                }.addOnFailureListener {
                    processing = false
                    isError = true
                    message = it
                    Toaster(
                        context = context,
                        message = "Login Failed",
                        image = R.drawable.logo
                    ).show()
                }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Box(modifier = Modifier.fillMaxWidth().align(Alignment.CenterHorizontally)) {
            Text(
                text = stringResource(id = R.string.or_login_with),
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = AppColor,
            )
        }
        Spacer(modifier = Modifier.height(60.dp))

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
//                .padding(horizontal = 16.dp)
                .clickable { },
            shape = RoundedCornerShape(40),
            color = Color(0xFF888888).copy(0.3f),
            contentColor = Color.Black
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 37.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(painter = painterResource(id = R.drawable.google), contentDescription = "")
                Text(
                    text = stringResource(id = R.string.continue_with_google),
                    fontWeight = FontWeight.Normal,
                    color = Color.Black,
                    fontSize = 13.sp,
                    modifier = Modifier.padding(start = 15.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(15.dp))

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(32.dp)
                .clickable { },
            shape = RoundedCornerShape(40),
            color = Color(0xFF888888).copy(0.3f),
            contentColor = Color.Black
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 37.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(painter = painterResource(id = R.drawable.apple), contentDescription = "")
                Text(
                    text = stringResource(id = R.string.continue_with_apple),
                    fontWeight = FontWeight.Normal,
                    color = Color.Black,
                    fontSize = 13.sp,
                    modifier = Modifier.padding(start = 15.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row(modifier = Modifier.padding(start = 90.dp)) {
            Text(
                text = stringResource(id = R.string.dont_have_an_account),
                fontSize = 13.sp
            )
            Text(
                text = stringResource(id = R.string.sign_up),
                fontSize = 13.sp,
                color = AppColor,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable {
                    navigator.navigate(SignUpDestination)
                }
            )
        }
    }
}



