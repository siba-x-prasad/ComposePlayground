package com.swasi.compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun AppNavigationGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = AppNavRoute.Splash.path
    ) {

    }
}