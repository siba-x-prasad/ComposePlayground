package com.swasi.composeplayground.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Created by Sibaprasad Mohanty on 11/03/2023.
 * siba.x.prasad@gmail.com
 */

@Composable
fun AppButton(
    text : String ="Hello",
    textColor : Color = Color.White,
    modifier: Modifier = Modifier.padding(0.dp),
    onClick : () -> Unit
){
    Button(modifier = Modifier.composed { modifier },
        onClick = onClick) {
        Text(text = text, Modifier.padding(start = 10.dp),
        color = textColor
            )
    }
}

@Composable
fun AppButtonWithIcon(
    text : String ="Hello",
    textColor : Color = Color.White,
    buttonIcon : ImageVector = Icons.Default.Email,
    modifier: Modifier = Modifier.padding(0.dp),
    onClick : () -> Unit
) {
    Button(modifier = Modifier.composed { modifier },
        onClick = onClick) {
//        Image(
//            painterResource(id = R.drawable.ic_cart),
//            contentDescription ="Cart button icon",
//            modifier = Modifier.size(20.dp))
        Icon(
            buttonIcon,
            contentDescription = text
        )
        Text(text = text, Modifier.padding(start = 10.dp),
        color = textColor
            )
    }
}

@Composable
fun AppOutlinedButton(
    text : String ="Hello",
    textColor : Color = Color.Black,
    modifier: Modifier = Modifier.padding(0.dp),
    onClick : () -> Unit
){
    OutlinedButton(modifier = Modifier.composed { modifier },
        onClick = onClick) {
        Text(text = text, Modifier.padding(start = 10.dp),
        color = textColor)
    }
}

@Composable
fun AppOutlinedButtonWithIcon(
    text : String ="Hello",
    textColor : Color = Color.White,
    buttonIcon : ImageVector = Icons.Default.Email,
    modifier: Modifier = Modifier.padding(0.dp),
    onClick : () -> Unit
) {
    OutlinedButton(modifier = Modifier.composed { modifier },
        onClick = onClick) {
        Icon(
            buttonIcon,
            contentDescription = text
        )
        Text(text = text, Modifier.padding(start = 10.dp),
        color = textColor
            )
    }
}



@Preview
@Composable
fun AppButtonPreview(){
    AppButton(onClick = {})
}

@Preview
@Composable
fun AppButtonWithIconPreview(){
    AppButtonWithIcon(onClick = {})
}

@Preview
@Composable
fun AppOutlinedButtonPreview(){
    AppOutlinedButton(onClick = {})
}

@Preview
@Composable
fun AppOutLinedButtonWithIconPreview(){
    AppOutlinedButtonWithIcon(onClick = {})
}
