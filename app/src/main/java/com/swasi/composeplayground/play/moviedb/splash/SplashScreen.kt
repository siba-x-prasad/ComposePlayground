package com.swasi.composeplayground.play.moviedb.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.swasi.composeplayground.R
import com.swasi.composeplayground.components.AppButton
import com.swasi.composeplayground.components.AppImageView
import com.swasi.composeplayground.components.ProgressIndicator
import com.swasi.composeplayground.ui.theme.ComposePlaygroundTheme

/**
 * Created by Sibaprasad Mohanty on 11/03/2023.
 * siba.x.prasad@gmail.com
 */

@Composable
fun SplashScreen(
    viewModel: SplashViewModel = hiltViewModel(),
    onNavigateToOnBoarding: () -> Unit
) {
    ComposePlaygroundTheme(darkTheme = false) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.White
        ) {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Gray)
                    .padding(10.dp)
            ) {
                AppImageView(
                    painter = painterResource(id = R.drawable.apple),
                    contentDescription = "splashImage",
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                        .align(Alignment.Center)
                )
                ProgressIndicator(
                    modifier = Modifier.align(
                        Alignment.BottomCenter
                    )
                )

                if (viewModel.isLoaded.value) {
                    onNavigateToOnBoarding()
                }

                AppButton(
                    text = "Skip", onClick = {
                        onNavigateToOnBoarding()
                    },
                    modifier = Modifier
                        .height(50.dp)
                        .align(Alignment.TopEnd)
                )

            }
        }
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    SplashScreen(SplashViewModel(), {})
}