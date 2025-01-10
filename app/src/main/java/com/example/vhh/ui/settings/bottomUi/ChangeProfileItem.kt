package com.example.vhh.ui.settings.bottomUi

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vhh.R
import com.example.vhh.ui.components.VhhButton
import com.example.vhh.ui.theme.AppColor
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.result.ResultBackNavigator
import com.ramcosta.composedestinations.spec.DestinationStyleBottomSheet

@Destination(style = DestinationStyleBottomSheet::class)
@Composable
fun ChangeProfileItem(
    onComplete: ResultBackNavigator<Boolean>
) {
    var processing by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.Unspecified)
            .padding(horizontal = 16.dp, vertical = 20.dp)
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .width(80.dp)
                .height(8.dp)
                .clip(CircleShape)
                .background(AppColor)
        )
        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            Icon(imageVector = Icons.Default.Edit,
//            Image(
//                painter = painterResource(id = R.drawable.edit),
                contentDescription = "approved",
//                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(20.dp)
                    .padding(horizontal = 5.dp)
            )
            Text(
                text = stringResource(id = R.string.make_changes_saved),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            )
        }
        Text(
            text = stringResource(id = R.string.save_changes_message),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier,
        )
        Spacer(modifier = Modifier.height(35.dp))

        VhhButton (
            Modifier
                .height(50.dp)
                .width(328.dp),
            processing = processing,
            text = stringResource(id = R.string.sure)
        ) {
            onComplete.navigateBack(result = true)
        }

        Spacer(modifier = Modifier.height(30.dp))
    }

}


