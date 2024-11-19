package com.swasi.composeplayground.play.moviedb.splash

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.swasi.composeplayground.R
import com.swasi.composeplayground.ui.theme.ComposePlaygroundTheme
import swasi.android.ui.components.AppButton
import swasi.android.ui.components.AppImageView
import swasi.android.ui.components.ProgressIndicator

/**
 * Created by Sibaprasad Mohanty on 11/03/2023.
 * siba.x.prasad@gmail.com
 */

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SplashScreen(
    viewModel: SplashViewModel = hiltViewModel(),
    onNavigateToOnBoarding: () -> Unit
) {
    DisposableEffect(Unit) {
        Log.i("SplashScreen", "Splash Screen Composed")
        onDispose { Log.i("SplashScreen", "Splash Screen  DISPOSED") }
    }
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
                    painter = painterResource(id = R.drawable.jet_pack_compose),
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