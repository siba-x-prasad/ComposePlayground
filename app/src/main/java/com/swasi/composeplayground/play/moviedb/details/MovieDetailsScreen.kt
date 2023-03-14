package com.swasi.composeplayground.play.moviedb.details

import androidx.compose.foundation.Image
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.swasi.composeplayground.components.AppText
import com.swasi.composeplayground.network.RestConfig
import com.swasi.composeplayground.ui.theme.ComposePlaygroundTheme


/**
 * Created by Sibaprasad Mohanty on 14/03/2023.
 * siba.x.prasad@gmail.com
 */

@Composable
fun MovieDetailsScreen(
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
                        val imageUrl = RestConfig.BASE_IMAGE_URL + posterImage
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