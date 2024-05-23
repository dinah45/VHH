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
import com.example.vhh.ui.destinations.HomeScreenDestination
import com.example.vhh.ui.destinations.LoginDestination
import com.example.vhh.ui.theme.AppColor
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@ExperimentalComposeUiApi
@Destination
@Composable
fun SignUp(navigator: DestinationsNavigator) {
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var phoneNumber by remember { mutableStateOf(TextFieldValue("")) }
    var gender by remember { mutableStateOf(TextFieldValue("")) }
    var region by remember { mutableStateOf(TextFieldValue("")) }
    val keyboardController = LocalSoftwareKeyboardController.current
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
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

            TextField(value = email, onValueChange = {email = it},
                label = {
                    androidx.compose.material3.Text(
                        text = "Email",
                        color = Color.Gray,
                        style = androidx.compose.material.MaterialTheme.typography.caption
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .size(50.dp)
                    .padding(horizontal = 16.dp),
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done
                ),
//                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        keyboardActions = KeyboardActions (onDone = {
                            keyboardController?.hide()
                }),
                maxLines = 1,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color(0xFF888888).copy(0.3f),
                    focusedIndicatorColor = AppColor,
                    disabledIndicatorColor = Color(0xFF888888).copy(0.3f),
                    cursorColor = AppColor,
                    disabledLabelColor =  Color(0xFF888888).copy(0.3f),
                    focusedLabelColor = AppColor,
                ),
                shape =  RoundedCornerShape(40)
            )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(value = phoneNumber, onValueChange = {phoneNumber = it},
            label = {
                androidx.compose.material3.Text(
                    text = "Phone Number",
                    color = Color.Gray,
                    style = androidx.compose.material.MaterialTheme.typography.caption
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .size(50.dp)
                .padding(horizontal = 16.dp),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
//            keyboardType = KeyboardType.Number,
                    keyboardActions = KeyboardActions (onDone = {
                keyboardController?.hide()
            }),
            maxLines = 1,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color(0xFF888888).copy(0.3f),
                focusedIndicatorColor = AppColor,
                disabledIndicatorColor = Color(0xFF888888).copy(0.3f),
                cursorColor = AppColor,
                disabledLabelColor =  Color(0xFF888888).copy(0.3f),
                focusedLabelColor = AppColor,
            ),
            shape =  RoundedCornerShape(40)
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(value = gender, onValueChange = {gender = it},
            label = {
                androidx.compose.material3.Text(
                    text = "Gender",
                    color = Color.Gray,
                    style = androidx.compose.material.MaterialTheme.typography.caption
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .size(50.dp)
                .padding(horizontal = 16.dp),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    keyboardActions = KeyboardActions (onDone = {
                        keyboardController?.hide()
            }),
            maxLines = 1,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color(0xFF888888).copy(0.3f),
                focusedIndicatorColor = AppColor,
                disabledIndicatorColor = Color(0xFF888888).copy(0.3f),
                cursorColor = AppColor,
                disabledLabelColor =  Color(0xFF888888).copy(0.3f),
                focusedLabelColor = AppColor,
            ),
            shape =  RoundedCornerShape(40)
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(value = region, onValueChange = {region = it},
            label = {
                androidx.compose.material3.Text(
                    text = "Region",
                    color = Color.Gray,
                    style = androidx.compose.material.MaterialTheme.typography.caption
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .size(50.dp)
                .padding(horizontal = 16.dp),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
//                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            keyboardActions = KeyboardActions (onDone = {
                keyboardController?.hide()
            }),
            maxLines = 1,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color(0xFF888888).copy(0.3f),
                focusedIndicatorColor = AppColor,
                disabledIndicatorColor = Color(0xFF888888).copy(0.3f),
                cursorColor = AppColor,
                disabledLabelColor =  Color(0xFF888888).copy(0.3f),
                focusedLabelColor = AppColor,

            ),
            shape =  RoundedCornerShape(40)
        )

        Spacer(modifier = Modifier.height(50.dp))
        VhhButton(text = stringResource(id = R.string.sign_up)) {
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
                navigator.navigate(HomeScreenDestination)
            }
        }
        Spacer(modifier = Modifier.height(40.dp))

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .size(35.dp)
                .padding(horizontal = 16.dp)
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
                .padding(horizontal = 16.dp)
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
                .padding(horizontal = 16.dp)
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
//        TextField(
//            modifier = Modifier.fillMaxWidth().size(32.dp),
//                    value = region,
//            label = { Text(text = "Region") },
//            onValueChange = { region = it },
//            singLine = true,
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
//            shape = RoundedCornerShape(20),
//            colors = TextFieldDefaults.textFieldColors(
//                backgroundColor = Color.Gray,
//                cursorColor = Color.Black
//            )
//        )
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
                    navigator.navigate(LoginDestination)
                }
            )
        }
    }
}