////package com.example.vhh.ui.components
////
//package com.example.ideavault.ui.components
//
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.text.KeyboardActions
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.material.MaterialTheme
//import androidx.compose.material.OutlinedTextField
//import androidx.compose.material.TextFieldDefaults
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextField
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.ExperimentalComposeUiApi
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.LocalSoftwareKeyboardController
//import androidx.compose.ui.res.colorResource
//import androidx.compose.ui.text.input.ImeAction
//import androidx.compose.ui.text.input.KeyboardType
//import androidx.compose.ui.unit.dp
//import com.example.vhh.R
//import com.example.vhh.ui.theme.AppColor
//
//@ExperimentalComposeUiApi
//@Composable
//fun VhhTextField(
//    label: String,
//    value: String,
//    onValueChanged: (String) -> Unit,
//    modifier: Modifier = Modifier,
//    onImeAction: () -> Unit = {},
//    maxLine: Int = 1,
//    ){
//    val keyboardController = LocalSoftwareKeyboardController.current
//
//    TextField(value = value, onValueChange = onValueChanged,
//        label = { Text(text = label,
//            color = Color.Gray,
//            style = MaterialTheme.typography.caption) },
//        modifier = Modifier.fillMaxWidth().size(32.dp).padding(horizontal = 16.dp),
//                keyboardOptions = KeyboardOptions.Default.copy(
//            imeAction = ImeAction.Done
//        ),
//        keyboardActions = KeyboardActions (onDone = {
//            onImeAction()
//            keyboardController?.hide()
//        }),
//        maxLines = maxLine,
//        colors = TextFieldDefaults.textFieldColors(
//            backgroundColor = Color(0xFF888888)
//        ),
//        shape = RoundedCornerShape(40)
//    )
//}
