package com.swasi.composeplayground.play.moviedb.onboarding

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
import com.swasi.composeplayground.components.AppButton
import com.swasi.composeplayground.components.AppImageView

/**
 * Created by Sibaprasad Mohanty on 11/03/2023.
 * siba.x.prasad@gmail.com
 */

@Composable
fun OnBoardingScreen(
    viewModel: OnBoardingViewModel = hiltViewModel(),
    onNavigateToSignIn: () -> Unit,
    onNavigateToSignUp: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .background(Color.Gray),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppImageView(
            painter = painterResource(id = R.drawable.apple),
            contentDescription = "Apple",
            modifier = Modifier.fillMaxSize(0.5f)
        )
        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center
        ) {
            AppButton(
                text = "SignIn", onClick = {
                    onNavigateToSignIn()
                },
                modifier = Modifier
                    .height(50.dp)
                    .weight(0.5f)
            )
            AppButton(
                text = "SignUp", onClick = {
                    onNavigateToSignUp()
                },
                modifier = Modifier
                    .height(50.dp)
                    .weight(0.5f)
            )
        }
    }
}