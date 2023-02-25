package com.swasi.composeplayground.play

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.swasi.composeplayground.mycomponents.AppButton
import com.swasi.composeplayground.mycomponents.OutLineTextField

@Composable
fun LoginScreen() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutLineTextField()
        Spacer(modifier = Modifier.height(20.dp))
        OutLineTextField()
        AppButton(title = "Login", onClick = {
            Toast.makeText(context, "asdasd", Toast.LENGTH_SHORT).show()
        }, modifier = Modifier.fillMaxWidth())
    }
}

@Preview(name = "LoginScreenPreview", device = "spec:width=411dp,height=891dp",
    backgroundColor = 0xFFFF9800
)
@Composable
fun LoginPreview(){
    LoginScreen()
}