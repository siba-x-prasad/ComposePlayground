package com.swasi.composeplayground.navigation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.swasi.composeplayground.navigation.common.DefaultButton
import com.swasi.composeplayground.ui.theme.ComposePlaygroundTheme

@Composable
fun LoginScreen(
    navigateToHome: () -> Unit
) {
    Column (
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Login Screen", fontSize = 40.sp)

        DefaultButton(
            text = "Log In",
            onClick = navigateToHome
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    ComposePlaygroundTheme(darkTheme = false) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.White
        ) {
            LoginScreen(
                navigateToHome = {}
            )
        }
    }
}
