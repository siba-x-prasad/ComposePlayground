package com.swasi.composeplayground.play.moviedb.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.swasi.composeplayground.components.AppButton
import com.swasi.composeplayground.components.AppOutlinedButton
import com.swasi.composeplayground.ui.theme.ComposePlaygroundTheme

/**
 * Created by Sibaprasad Mohanty on 11/03/2023.
 * siba.x.prasad@gmail.com
 */

@Composable
fun MovieHomeScreen(
    viewModel: MovieHomeViewModel = hiltViewModel(),
    onNavigateToMovieScreen: () -> Unit,
    onNavigateToTvShow: () -> Unit
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row {
                        Text(
                            "Home Screen",
                            color = Color.White
                        )
                    }
                })
        },
        content = {

            ComposePlaygroundTheme(darkTheme = false) {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(it),
                    color = Color.White
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.White)
                            .padding(10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {

                        Spacer(modifier = Modifier.height(10.dp))
                        AppButton(text = "Movie Home Screen", onClick = {
                        })
                        Spacer(modifier = Modifier.height(10.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            AppOutlinedButton(
                                text = "TvShow", onClick = {
                                    onNavigateToTvShow()
                                },
                                modifier = Modifier
                                    .width(100.dp)
                                    .height(100.dp)
                            )
                            AppOutlinedButton(text = "Movie List",
                                modifier = Modifier
                                    .width(100.dp)
                                    .height(100.dp),
                                onClick = {
                                    onNavigateToMovieScreen()
                                })
                        }
                    }
                }
            }
        })
}