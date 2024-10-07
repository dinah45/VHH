package com.example.vhh.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vhh.ui.theme.AppColor

@Composable
fun VhhButton(
    modifier: Modifier = Modifier,
    text: String,
    processing: Boolean = false,
    enabled: Boolean = true,
    color: Color = AppColor,
    contentColor: Color = Color.White,
    onClick: () -> Unit
) {
    Button(
        enabled = !processing && enabled,
        onClick = onClick,
        colors = androidx.compose.material3.ButtonDefaults.buttonColors(
            containerColor = color,
            contentColor = contentColor,
            disabledContainerColor = color.copy(alpha = 0.5f),
            disabledContentColor = Color.White
        ),
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
    ) {
        if (processing) {
            CircularProgressIndicator(
                color = Color.White,
                modifier = Modifier
                    .size(32.dp)
                    .align(Alignment.CenterVertically),
                strokeWidth = 2.dp,
                strokeCap = StrokeCap.Butt
            )
        } else {
            Text(text = text, style = MaterialTheme.typography.bodyLarge, color = Color.White)
        }
    }
}
@Composable
fun VhhButton1(
    modifier: Modifier = Modifier,
    text: String,
    processing: Boolean = false,
    enabled: Boolean = true,
    color: Color =  Color(0xFF888888).copy(0.3f),
//    leadingIcon: @Composable (() -> Unit)? = null,
contentColor: Color = AppColor,
    onClick: () -> Unit
) {
    Button(
        enabled = !processing && enabled,
        onClick = onClick,
        colors = androidx.compose.material3.ButtonDefaults.buttonColors(
            containerColor = color,
            contentColor = contentColor,
            disabledContainerColor = color.copy(alpha = 0.5f),
            disabledContentColor = Color.White
        ),
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp),
        shape = RoundedCornerShape(20.dp),
//leadingIcon = leadingIcon
    ) {
        if (processing) {
            CircularProgressIndicator(
                color = Color.White,
                modifier = Modifier
                    .size(32.dp)
                    .align(Alignment.CenterVertically),
                strokeWidth = 2.dp,
                strokeCap = StrokeCap.Butt
            )
        } else {
            Text(text = text, style = MaterialTheme.typography.bodyLarge, color = AppColor)
        }
    }
}