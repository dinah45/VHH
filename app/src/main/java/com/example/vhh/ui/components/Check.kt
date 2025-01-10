package com.example.vhh.ui.components

import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.vhh.ui.theme.AppColor

@Composable
fun Check(){
    val checked = remember {mutableStateOf(false)}
   Checkbox(
        checked = checked.value,
        onCheckedChange = {checked.value = it},
        modifier = Modifier,
        colors = CheckboxDefaults.colors(
            checkedColor = AppColor,
            uncheckedColor = Color.White,
            checkmarkColor = AppColor,
            disabledColor = MaterialTheme.colorScheme.background,
                    disabledIndeterminateColor = AppColor.copy(0.5f)
        )
    )
}