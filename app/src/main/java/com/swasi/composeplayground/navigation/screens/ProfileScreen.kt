package com.swasi.composeplayground.navigation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.swasi.composeplayground.navigation.common.DefaultButton
import com.swasi.composeplayground.ui.theme.ComposePlaygroundTheme

@Composable
fun ProfileScreen(
    id: Int,
    showDetails: Boolean,
    popBackStack: () -> Unit,
    popUpToLogin: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Profile Id: $id", fontSize = 40.sp)

        Spacer(modifier = Modifier.height(5.dp))
        Text("Details: $showDetails", fontSize = 40.sp)

        DefaultButton(
            text = "Back",
            onClick = popBackStack
        )

        DefaultButton(
            text = "Log Out",
            onClick = popUpToLogin
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
            ProfileScreen(
                id = 7,
                showDetails = true,
                popBackStack = {},
                popUpToLogin = {}
            )
        }
    }
}