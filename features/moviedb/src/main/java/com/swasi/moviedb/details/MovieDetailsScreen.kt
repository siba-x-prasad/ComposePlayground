package com.swasi.moviedb.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.google.gson.Gson
import com.swasi.domain.moviedb.MovieData
import com.swasi.ui.components.AppButton
import com.swasi.ui.components.AppText
import com.swasi.ui.theme.ComposePlaygroundTheme
import swasi.android.network.RestConfig


/**
 * Created by Sibaprasad Mohanty on 14/03/2023.
 * siba.x.prasad@gmail.com
 */

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun MovieDetailsScreen(
    movieDataInJson: String,
    popBackStack: () -> Unit,
    popUpToLogin: () -> Unit
) {

    val selectedMovie = Gson().fromJson(movieDataInJson, MovieData::class.java)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row {
                        Text(
                            "Movie Details",
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
                        AppButton(
                            text = "Back",
                            onClick = popBackStack
                        )

                        AppButton(
                            text = "Log Out",
                            onClick = popUpToLogin
                        )
                        val imageUrl =
                            RestConfig.BASE_IMAGE_URL + selectedMovie?.poster_path// selectedMovie?.poster_path
                        Image(
                            painter = rememberAsyncImagePainter(imageUrl),
                            contentDescription = selectedMovie?.title ?: "No Title Found",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxSize(0.5F)
                        )
                        AppText(
                            text = selectedMovie?.title ?: "No Title Found",
                            size = 20.sp
                        )
                    }
                }
            }
        })
}