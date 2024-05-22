package com.example.vhh.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember

@Composable
fun VhhTextField(
    value: String,
        onValueChange: (String) -> Unit,
    label: String,
        modifier: Modifier = Modifier,
    keyboardType: KeyboardType,
){
    Column {
        TextField(
            value = value,
            onValueChange = onValueChange,
            label = {
                Text(
                    text = label,
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Gray.copy(alpha = 0.7f),
                )
            },
            singleLine = true,
            textStyle = MaterialTheme.typography.bodyLarge,
            singleLine = true,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = Color.Gray.copy(0.7f),
                cursorColor = Color.Black,
            ),
            shape = RoundedCornerShape(20.dp),
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
    }
}
//
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.material.Text
//import androidx.compose.material.TextField
//import androidx.compose.material.TextFieldDefaults
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Edit
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.text.input.KeyboardType
//import androidx.compose.ui.text.input.TextFieldValue
//import androidx.compose.ui.text.input.VisualTransformation
//import androidx.compose.ui.unit.dp
//
//@Composable
//fun VhhTextField(
//    modifier: Modifier = Modifier,
//    value: String,
//    onValueChange: (String) -> Unit,
//    keyboardType: KeyboardType,
//    isError: Boolean = false,
//    isEditable: Boolean = true,
//    showEditIcon: Boolean = false,
//    singleLine:Boolean = true,
//    enabled: Boolean = true,
//    label: String){
//    val context = LocalContext.current
////    var visible by remember {
////        mutableStateOf(keyboardType != KeyboardType.Password)
////    }
////    var searchQuery by remember {
////        mutableStateOf(TextFieldValue(""))
////    }
//    var isEdit by remember {
//        mutableStateOf(showEditIcon)
//    }
//
//    Column {
//
//        TextField(
//            isError = isError,
//            value = value,
//            onValueChange = onValueChange,
//            label = {
//                Text(
//                    text = label,
//                    style = MaterialTheme.typography.bodyLarge,
//                    color = Color.Gray.copy(alpha = 0.7f),
//                )
//            },
//            textStyle = MaterialTheme.typography.bodyLarge,
//            singleLine = singleLine,
//            colors = TextFieldDefaults.textFieldColors(
//                backgroundColor = Color.Gray.copy(0.7f),
//                cursorColor = Color.Black,
////                trailingIconColor = CakkieBrown,
////                disabledTrailingIconColor = CakkieBrown.copy(alpha = 0.5f),
//            ),
//            shape = RoundedCornerShape(20.dp),
//            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
//            modifier = modifier
//                .fillMaxWidth(),
////            trailingIcon = {
////                if (keyboardType == KeyboardType.Password) {
////                    if (visible) {
////                        Image(
////                            painter = painterResource(id = R.drawable.eye_closed),
////                            contentDescription = "eye closed",
////                            modifier = Modifier.clickable {
////                                visible = !visible
////                            }
////                        )
////                    } else {
////                        Image(
////                            painter = painterResource(id = R.drawable.eye_open),
////                            contentDescription = "eye closed",
////                            modifier = Modifier.clickable {
////                                visible = !visible
////                            }
////                        )
////                    }
////                }
//                if (isEdit) {
//                    Image(
//                        imageVector = Icons.Default.Edit,
//                        contentDescription = "edit",
//                        modifier = Modifier.size(16.dp)
//
//                    )
//                } else {
//                    VisualTransformation.None
//                }
//        )
//    }
//}