package com.swasi.composeplayground.componentExamples

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp


class TextFieldActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreen()
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun TextFieldExample() {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val textState = remember { mutableStateOf(TextFieldValue()) }
            TextField(
                value = textState.value,
                onValueChange = { textState.value = it }
            )
            Text(textState.value.text)
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun LoginScreen() {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val textState = remember { mutableStateOf(TextFieldValue()) }
            TextField(
                modifier = Modifier.align(CenterHorizontally),
                value = textState.value,
                onValueChange = { textState.value = it },
                label = { Text("Email Id") }
            )
//        Text( textState.value.text)
            Spacer(modifier = Modifier.height(4.dp))
            TextField(
                modifier = Modifier.align(CenterHorizontally),
                value = textState.value,
                onValueChange = { textState.value = it },
                label = { Text("Password") }
            )
            Button(
                onClick = {
                    Toast.makeText(
                        this@TextFieldActivity,
                        "Login CLicked",
                        Toast.LENGTH_SHORT
                    ).show()
                }, colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red,
                    contentColor = Color.White
                )
            ) {
                Text("Login")
            }
        }
    }

    @Composable
    fun showTextInputWithImage() {
        /*TextField(
            modifier = Modifier.padding(8.dp).fillMaxWidth().background(Color.White),
            label = { Text("Password") },
            placeholder = { Text("012345") },
            leadingIcon = { Icon(asset = Icons.Default.Phone) },
            trailingIcon = { Icon(asset = Icons.Default.Edit) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        )*/
    }
}