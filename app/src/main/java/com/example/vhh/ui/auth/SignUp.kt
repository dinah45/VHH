package com.example.vhh.ui.auth

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
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Surface
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vhh.R
import com.example.vhh.ui.components.VhhButton
import com.example.vhh.ui.components.VhhInputField
import com.example.vhh.ui.destinations.HomeScreenDestination
import com.example.vhh.ui.destinations.LoginDestination
import com.example.vhh.ui.theme.AppColor
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@ExperimentalComposeUiApi
@Destination
@Composable
fun SignUp() {
//fun SignUp(navigator: DestinationsNavigator) {
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var phoneNumber by remember { mutableStateOf(TextFieldValue("")) }
    var gender by remember { mutableStateOf(TextFieldValue("")) }
    var region by remember { mutableStateOf(TextFieldValue("")) }
    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current
//    var password by remember { mutableStateOf(TextFieldValue("")) }
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
            onValueChange = {
                isError = false
                gender = it
            },
            placeholder = stringResource(id = R.string.gender),
            keyboardType = KeyboardType.Text,
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
            value = region,
            onValueChange = {
                isError = false
                region = it
            },
            placeholder = stringResource(id = R.string.region),
            keyboardType = KeyboardType.Text,
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
        Spacer(modifier = Modifier.height(50.dp))
        VhhButton(text = stringResource(id = R.string.sign_up)) {
            isEmailValid = emailRegex.matches(input = email.text)
            if (isEmailValid) {
                processing = true}
            if (email.text.isEmpty()&&phoneNumber.text.isEmpty()&&gender.text.isEmpty()&&region
                .text.isEmpty()){
                Toast.makeText(context, "Please fill all the fields", Toast.LENGTH_SHORT).show()
            }else if (email.text.isEmpty() ){
                Toast.makeText(context, "Please enter your email", Toast.LENGTH_SHORT).show()
            }else if (phoneNumber.text.isEmpty()){
                Toast.makeText(context, "Please enter your phone number", Toast.LENGTH_SHORT).show()
            }else if (gender.text.isEmpty()){
                Toast.makeText(context, "Please enter your gender", Toast.LENGTH_SHORT).show()
            }else if (region.text.isEmpty()){
                Toast.makeText(context, "Please enter your region", Toast.LENGTH_SHORT).show()
            }else{
//                navigator.navigate(HomeScreenDestination)
            }
        }
        Spacer(modifier = Modifier.height(40.dp))

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .size(35.dp)
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
                .size(35.dp)
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
        Spacer(modifier = Modifier.height(10.dp))

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .size(35.dp)
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
Image(imageVector = Icons.Default.Email, contentDescription = "")
                Text(text = stringResource(id = R.string.continue_with_email),
                  fontWeight =  FontWeight.Medium,
                    color = Color.Black,
                    fontSize = 13.sp,
                    modifier = Modifier.padding(start = 15.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(50.dp))
        Row (modifier = Modifier.padding(start= 90.dp)){
            Text(
                text = stringResource(id = R.string.already_have_an_account),
                fontSize = 13.sp
            )
            Text(
                text = stringResource(id = R.string.login),
                fontSize = 13.sp,
                color = AppColor,
                modifier = Modifier.clickable {
//                    navigator.navigate(LoginDestination)
                }
            )
        }
    }
}