package com.example.vhh.ui.auth

import android.widget.Toast
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Surface
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vhh.ui.components.VhhButton
import com.example.vhh.R
import com.example.vhh.ui.components.VhhButton1
import com.example.vhh.ui.destinations.HomeScreenDestination
import com.example.vhh.ui.destinations.SignUpDestination
import com.example.vhh.ui.theme.AppColor
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@ExperimentalComposeUiApi
@Destination
@Composable
fun Login(navigator: DestinationsNavigator) {
    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
    Column(
        modifier = Modifier
            .fillMaxSize()
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
            modifier = Modifier.padding(start = 16.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = stringResource(id = R.string.login),
style = MaterialTheme.typography.headlineLarge,
            color = AppColor,
            modifier = Modifier.padding(start = 16.dp)
        )
        Spacer(modifier = Modifier.height(40.dp))
        TextField(value = email, onValueChange = {email = it},
            label = {
                Text(
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
            keyboardActions = KeyboardActions (onDone = {
                keyboardController?.hide()
            }),
//            keyboardType = KeyboardType.Email,
            maxLines = 1,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color(0xFF888888).copy(0.3f)
            ),
            shape = RoundedCornerShape(40)
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(value = password, onValueChange = {password = it},
            label = {
                Text(
                    text = "Password",
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
//            keyboardType = KeyboardType.Password,
            keyboardActions = KeyboardActions (onDone = {
                keyboardController?.hide()
            }),
            maxLines = 1,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color(0xFF888888).copy(0.3f)
            ),
            shape =  RoundedCornerShape(40)
        )
        Spacer(modifier = Modifier.height(50.dp))
        VhhButton(text = stringResource(id = R.string.login)) {
            if (email.text.isEmpty() && password.text.isEmpty()) {
                Toast.makeText(context, "Please enter your email and password", Toast.LENGTH_SHORT).show()
            }else if (email.text.isEmpty() || password.text.isEmpty()) {
                Toast.makeText(context, "Please enter your email and password", Toast.LENGTH_SHORT).show()
            }else {
                navigator.navigate(HomeScreenDestination)
            }
        }
        Spacer(modifier = Modifier.height(100.dp))
        Box(modifier = Modifier.fillMaxWidth().align(Alignment.CenterHorizontally)) {
            Text(
                text = stringResource(id = R.string.or_login_with),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = AppColor, modifier = Modifier.padding(start = 150.dp)
            )
        }
        Spacer(modifier = Modifier.height(80.dp))

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .size(32.dp)
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
        Spacer(modifier = Modifier.height(15.dp))

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .size(32.dp)
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
                Text(text = stringResource(id = R.string.continue_with_apple),
                    fontWeight =  FontWeight.Medium,
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
                .size(32.dp)
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