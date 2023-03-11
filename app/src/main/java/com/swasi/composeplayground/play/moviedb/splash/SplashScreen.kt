package com.swasi.composeplayground.play.moviedb.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.swasi.composeplayground.R
import com.swasi.composeplayground.components.AppImageView
import com.swasi.composeplayground.components.ProgressIndicator

/**
 * Created by Sibaprasad Mohanty on 11/03/2023.
 * siba.x.prasad@gmail.com
 */

@Composable
fun SplashScreen(
    viewModel: SplashViewModel = hiltViewModel(),
    onNavigateToOnBoarding: () -> Unit
) {
    viewModel.load()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .background(Color.Gray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AppImageView(
            painter = painterResource(id = R.drawable.apple),
            contentDescription = "splashImage",
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
        )
        ProgressIndicator()
        if (viewModel.isLoaded.value) {
            onNavigateToOnBoarding()
        }
    }
}