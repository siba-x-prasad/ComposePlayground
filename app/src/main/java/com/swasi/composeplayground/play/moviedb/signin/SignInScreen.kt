package com.swasi.composeplayground.play.moviedb.signin

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.swasi.composeplayground.play.moviedb.splash.SplashViewModel


/**
 * Created by Sibaprasad Mohanty on 11/03/2023.
 * siba.x.prasad@gmail.com
 */

@Composable
fun SignInScreen(
    viewModel: SplashViewModel = hiltViewModel(),
    onNavigateToSignUp: () -> Unit,
    onNavigateToForgotPassword: () -> Unit
) {
    Column() {

    }
}