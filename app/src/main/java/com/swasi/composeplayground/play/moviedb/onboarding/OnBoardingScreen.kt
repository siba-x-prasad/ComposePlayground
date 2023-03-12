package com.swasi.composeplayground.play.moviedb.onboarding

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
import com.swasi.composeplayground.ui.theme.ComposePlaygroundTheme

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
    ComposePlaygroundTheme(darkTheme = false) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.White
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
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
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    AppButton(
                        text = "SignIn", onClick = {
                            onNavigateToSignIn()
                        },
                        modifier = Modifier
                            .height(50.dp)
                    )
                    Spacer(modifier = Modifier.width(50.dp))
                    AppButton(
                        text = "SignUp", onClick = {
                            onNavigateToSignUp()
                        },
                        modifier = Modifier
                            .height(50.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun OnBoardingScreenPreview() {
    OnBoardingScreen(OnBoardingViewModel(), {}, {})
}