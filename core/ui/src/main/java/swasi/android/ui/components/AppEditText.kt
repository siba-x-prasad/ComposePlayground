package swasi.android.ui.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleTextField() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = text,
        onValueChange = { newText ->
            text = newText
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LabelAndPlaceHolder() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = text,
        onValueChange = {
            text = it
        },
        label = { Text(text = "Your Label") },
        placeholder = { Text(text = "Your Placeholder/Hint") },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldWithInputType() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = text,
        label = { Text(text = "Number Input Type") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        onValueChange = { it ->
            text = it
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutLineTextField() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(
        value = text,
        label = { Text(text = "Enter Your Name") },
        onValueChange = {
            text = it
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldWithIcons() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    return OutlinedTextField(
        value = text,
        leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "emailIcon") },
        //trailingIcon = { Icon(imageVector = Icons.Default.Add, contentDescription = null) },
        onValueChange = {
            text = it
        },
        label = { Text(text = "Email address") },
        placeholder = { Text(text = "Enter your e-mail") },
    )
}