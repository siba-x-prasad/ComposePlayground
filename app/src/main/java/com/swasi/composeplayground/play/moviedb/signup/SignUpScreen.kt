package com.swasi.composeplayground.play.moviedb.signup

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel


/**
 * Created by Sibaprasad Mohanty on 11/03/2023.
 * siba.x.prasad@gmail.com
 */
@Composable
fun SignUpScreen(
    viewModel: SignUpViewModel = hiltViewModel(),
    onNavigateToSIgnIn: () -> Unit,
    onNavigateToHome: () -> Unit
) {

    Column() {

    }
}