package com.swasi.composeplayground.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
fun AppTextField(
    text : String = "Hello",
    hintText : String = "Hint",
    onValueChange : (String) -> Unit,
    modifier: Modifier = Modifier.padding(0.dp)
){
    TextField(
    value = text,
    onValueChange = onValueChange,
        label = {
            Text(hintText)
        },
        modifier = Modifier.composed { modifier }
    )
}

@Composable
fun AppTextFieldWithIcon(
    text : String = "Hello",
    hintText : String = "Hint",
    onValueChange : (String) -> Unit,
    modifier: Modifier = Modifier.padding(0.dp),
    icon : ImageVector = Icons.Default.Email,
    iconColor : Color = Color.Black
){
    TextField(
        value = text,
        onValueChange = onValueChange,
        label = {
            Text(hintText)
        },
        modifier = Modifier.composed { modifier },
        leadingIcon = {
           Icon(imageVector = icon, contentDescription = text,
           tint = iconColor
               )
        }
    )
}


@Composable
fun AppOutLinedTextField(
    text : String = "Hello",
    hintText : String = "Hint",
    onValueChange : (String) -> Unit,
    modifier: Modifier = Modifier.padding(0.dp)
){
    OutlinedTextField(
        value = text,
        onValueChange = onValueChange,
        label = {
            Text(hintText)
        },
        modifier = Modifier.composed { modifier }
    )
}

@Composable
fun AppOutLinedTextFieldWithIcon(
    text : String = "Hello",
    hintText : String = "Hint",
    onValueChange : (String) -> Unit,
    modifier: Modifier = Modifier.padding(0.dp),
    icon : ImageVector = Icons.Default.Email,
    iconColor : Color = Color.Black
){
    OutlinedTextField(
        value = text,
        onValueChange = onValueChange,
        label = {
            Text(hintText)
        },
        modifier = Modifier.composed { modifier },
        leadingIcon = {
            Icon(imageVector = icon, contentDescription = text,
                tint = iconColor
            )
        }
    )
}

@Preview
@Composable
fun AppTextFieldPreview(){
    AppTextField(onValueChange = {

    })
}

@Preview
@Composable
fun AppTextFieldWithIconPreview(){
    AppTextFieldWithIcon(onValueChange = {

    })
}

@Preview
@Composable
fun AppOutLinedTextFieldPreview(){
    AppOutLinedTextField(onValueChange = {

    })
}

@Preview
@Composable
fun AppOutLinedTextFieldWithIconPreview(){
    AppOutLinedTextFieldWithIcon(onValueChange = {

    })
}