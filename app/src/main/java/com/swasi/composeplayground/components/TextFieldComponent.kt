package com.swasi.composeplayground.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Created by Sibaprasad Mohanty on 11/03/2023.
 * siba.x.prasad@gmail.com
 */

@Composable
fun AppTextField(
    label: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    onTextChanged: (String) -> Unit,
    onNext: ((KeyboardActionScope) -> Unit)? = null,
    onDone: ((KeyboardActionScope) -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    modifier: Modifier = Modifier.padding(0.dp)
) {
    var text by remember {
        mutableStateOf("")
    }

    TextField(
        modifier = Modifier.composed { modifier },
        value = text,
        onValueChange = {
            text = it
            onTextChanged(it)
        },
        label = {
            Text(label)
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        keyboardActions = KeyboardActions(
            onDone = onDone?.let { it },
            onNext = onNext?.let { it }
        ),
        isError = isError,
        visualTransformation = visualTransformation
    )
}

@Composable
fun AppTextFieldWithIcon(
    label: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    onTextChanged: (String) -> Unit,
    onNext: ((KeyboardActionScope) -> Unit)? = null,
    onDone: ((KeyboardActionScope) -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    modifier: Modifier = Modifier.padding(0.dp),
    icon: ImageVector = Icons.Default.Email,
    iconColor: Color = Color.Black
) {
    var text by remember {
        mutableStateOf("")
    }

    TextField(
        modifier = Modifier.composed { modifier },
        value = text,
        onValueChange = {
            text = it
            onTextChanged(it)
        },
        label = {
            Text(label)
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        keyboardActions = KeyboardActions(
            onDone = onDone?.let { it },
            onNext = onNext?.let { it }
        ),
        isError = isError,
        visualTransformation = visualTransformation,
        leadingIcon = {
            Icon(
                imageVector = icon, contentDescription = text,
                tint = iconColor
            )
        }
    )
}


@Composable
fun AppOutLinedTextField(
    label: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    onTextChanged: (String) -> Unit,
    onNext: ((KeyboardActionScope) -> Unit)? = null,
    onDone: ((KeyboardActionScope) -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    modifier: Modifier = Modifier.padding(0.dp)
) {
    var text by remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        modifier = Modifier.composed { modifier },
        value = text,
        onValueChange = {
            text = it
            onTextChanged(it)
        },
        label = {
            Text(label)
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        keyboardActions = KeyboardActions(
            onDone = onDone?.let { it },
            onNext = onNext?.let { it }
        ),
        isError = isError,
        visualTransformation = visualTransformation
    )
}

@Composable
fun AppOutLinedTextFieldWithIcon(
    label: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    onTextChanged: (String) -> Unit,
    onNext: ((KeyboardActionScope) -> Unit)? = null,
    onDone: ((KeyboardActionScope) -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    modifier: Modifier = Modifier.padding(0.dp),
    icon: ImageVector = Icons.Default.Email,
    iconColor: Color = Color.Black
) {

    var text by remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        modifier = Modifier.composed { modifier },
        value = text,
        onValueChange = {
            text = it
            onTextChanged(it)
        },
        label = {
            Text(label)
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        keyboardActions = KeyboardActions(
            onDone = onDone?.let { it },
            onNext = onNext?.let { it }
        ),
        isError = isError,
        visualTransformation = visualTransformation,
        leadingIcon = {
            Icon(
                imageVector = icon, contentDescription = text,
                tint = iconColor
            )
        }
    )
}

@Preview
@Composable
fun AppTextFieldPreview(){
    AppTextField(label = "", onTextChanged = {

    })
}

@Preview
@Composable
fun AppTextFieldWithIconPreview(){
    AppTextFieldWithIcon(label = "", onTextChanged = {

    })
}

@Preview
@Composable
fun AppOutLinedTextFieldPreview(){
    AppOutLinedTextField(label = "", onTextChanged = {

    })
}

@Preview
@Composable
fun AppOutLinedTextFieldWithIconPreview(){
    AppOutLinedTextFieldWithIcon(label = "", onTextChanged = {

    })
}