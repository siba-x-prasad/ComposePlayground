package com.swasi.composeplayground.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.swasi.composeplayground.navigation.navigation.NavGraph
import com.swasi.composeplayground.ui.theme.ComposePlaygroundTheme

class NavigationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
private fun MainScreen() {
    ComposePlaygroundTheme() {
        val navController = rememberNavController()
        NavGraph(navController)
    }
}