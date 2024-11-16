package com.swasi.composeplayground.play.moviedb.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
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
import swasi.android.ui.theme.Colors
import swasi.android.ui.components.AppButton
import swasi.android.ui.components.AppImageView

/**
 * Created by Sibaprasad Mohanty on 11/03/2023.
 * siba.x.prasad@gmail.com
 */

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun OnBoardingScreen(
    viewModel: OnBoardingViewModel = hiltViewModel(),
    onNavigateToSignIn: () -> Unit,
    onNavigateToSignUp: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row {
                        Text(
                            "Onboarding Screen",
                            color = Colors.white
                        )
                    }
                },
                colors = TopAppBarColors(
                    containerColor = Colors.teal700,
                    scrolledContainerColor = Colors.white,
                    navigationIconContentColor = Colors.white,
                    titleContentColor = Colors.white,
                    actionIconContentColor = Colors.white
                ),
                actions = {
                    IconButton(onClick = {

                    }) {
                        Icon(
                            Icons.Outlined.CheckCircle,
                            "Home"
                        )
                    }

                    IconButton(onClick = {
                        onNavigateToSignIn()
                    }) {
                        Icon(
                            Icons.Outlined.AccountCircle,
                            "Movie"
                        )
                    }

                    IconButton(
                        onClick = {

                        }) {
                        Icon(
                            Icons.Outlined.Face,
                            "Favorite"
                        )
                    }
                })
        },
        content = {
            ComposePlaygroundTheme(
                darkTheme = false
            ) {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(it),
                    color = Color.White
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.White),
                        verticalArrangement = Arrangement.SpaceAround,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        AppImageView(
                            painter = painterResource(id = R.drawable.jet_pack_compose),
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
    )
}

@Preview
@Composable
fun OnBoardingScreenPreview() {
    OnBoardingScreen(OnBoardingViewModel(), {}, {})
}