package com.swasi.composeplayground.play.moviedb.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.swasi.composeplayground.navigation.common.DefaultButton
import com.swasi.composeplayground.ui.theme.ComposePlaygroundTheme
import swasi.android.ui.theme.Colors
import com.swasi.domain.tvshows.MovieData
import swasi.android.network.RestConfig
import swasi.android.ui.components.AppText


/**
 * Created by Sibaprasad Mohanty on 14/03/2023.
 * siba.x.prasad@gmail.com
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieDetailsScreen(
    selectedMovie: MovieData? = null,
    name: String?,
    posterImage: String?,
    popBackStack: () -> Unit,
    popUpToLogin: () -> Unit
) {
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
                },
                colors = TopAppBarColors(
                    containerColor = Colors.teal700,
                    scrolledContainerColor = Colors.white,
                    navigationIconContentColor = Colors.white,
                    titleContentColor = Colors.white,
                    actionIconContentColor = Colors.white
                )
            )
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
                        DefaultButton(
                            text = "Back",
                            onClick = popBackStack
                        )

                        DefaultButton(
                            text = "Log Out",
                            onClick = popUpToLogin
                        )
                        val imageUrl =
                            RestConfig.BASE_IMAGE_URL + posterImage// selectedMovie?.poster_path
                        Image(
                            painter = rememberAsyncImagePainter(imageUrl),
                            contentDescription = name,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxSize(0.5F)
                        )
                        AppText(
                            text = name!!,
                            size = 20.sp
                        )
                    }
                }
            }
        })
}