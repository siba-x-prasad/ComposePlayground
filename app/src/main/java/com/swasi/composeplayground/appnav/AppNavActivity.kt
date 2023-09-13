package com.swasi.composeplayground.appnav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.swasi.composeplayground.appnav.appmoviedb.MovieNavGraph
import com.swasi.composeplayground.ui.theme.ComposePlaygroundTheme
import dagger.hilt.android.AndroidEntryPoint
import swasi.android.ui.components.AppButton

@AndroidEntryPoint
class AppNavActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
private fun MainScreen() {
    val navController = rememberNavController()
//    AppNavGraph(navController)
    MovieNavGraph(navController)
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
private fun MainScreen1() {

    ComposePlaygroundTheme() {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Row {
                            Text(
                                "Sign In",
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
//                        val focusManager = LocalFocusManager.current
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color.White)
                                .padding(10.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            AppButton(text = "Local Movie DB", onClick = {
//                                AppMovieDbScreen()
                            })
                            Spacer(modifier = Modifier.height(10.dp))
                            AppButton(text = "Feature Account", onClick = {
                            })
                            Spacer(modifier = Modifier.height(10.dp))
                            AppButton(text = "Feature Home", onClick = {
                            })
                            Spacer(modifier = Modifier.height(10.dp))
                            AppButton(text = "Feature Movie DB", onClick = {
                            })
                            Spacer(modifier = Modifier.height(10.dp))
                            AppButton(text = "Feature Profile", onClick = {

                            })
                            Spacer(modifier = Modifier.height(10.dp))
                            AppButton(text = "SignIn", onClick = {
                            })
                        }
                    }
                }
            })
    }
}