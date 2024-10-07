package com.example.vhh.ui.auth

import androidx.compose.ui.graphics.Color
import com.example.vhh.ui.theme.AppColor
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction.Companion.Done
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun OtpInput(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    isError: Boolean = false,
    readOnly: Boolean = false
) {

    BasicTextField(
        maxLines = 1,
        singleLine = true,
        value = value.text.take(4), // Limit the text to 4 characters
        onValueChange = { onValueChange(TextFieldValue(it)) }, // Update the value to only keep the first 4 characters
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.NumberPassword,
            imeAction = Done
        ),
        readOnly = readOnly,
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            repeat(4) { index ->
                val number = when {
                    index >= value.text.length -> ""
                    else -> value.text[index].toString()
                }

                Box(
                    modifier = Modifier
                        .border(
                            BorderStroke(1.dp, if (isError) Color.Red else AppColor),
                            RoundedCornerShape(8.dp)
                        )
                        .clip(RoundedCornerShape(8.dp))
                        .size(if (readOnly) 50.dp else 70.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = if (readOnly && number.isNotEmpty()) "*" else number,
                        style = MaterialTheme.typography.bodyLarge,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }

        }
    }
}