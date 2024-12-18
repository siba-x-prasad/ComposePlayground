package com.swasi.composeplayground.play.moviedb.movies

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.swasi.composeplayground.R
import swasi.android.ui.theme.Colors
import com.swasi.domain.tvshows.MovieData
import swasi.android.network.RestConfig
import swasi.android.ui.components.AppButton
import swasi.android.ui.components.ProgressIndicator

/**
 * Created by Sibaprasad Mohanty on 14/03/2023.
 * siba.x.prasad@gmail.com
 */

private val TAG = "MovieScreen"
// https://stackoverflow.com/questions/68694031/jetpack-compose-passing-data-from-lazy-column-into-another-composable

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun MovieScreen(
    viewModel: MovieViewModel = hiltViewModel(),
    navigateToMovieDetails: (String, String) -> Unit,
    navigateToDetails: (String, String) -> Unit
) {

    var selectedMovieData by remember {
        mutableStateOf<MovieData?>(null)
    }

    val nameState = remember { mutableStateOf("") }
    val posterState = remember { mutableStateOf("") }

    LaunchedEffect(Unit, block = {
        viewModel.getPopularMovies()
    })

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row {
                        Text(
                            "Popular Movies",
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
        }
    ) {
        Column() {
            AppButton(text = "Movie Details", modifier = Modifier.fillMaxWidth(),
                onClick = { navigateToMovieDetails("Siba", "kjhkhkjhk") }
            )
            when (val state = viewModel.movieListState.collectAsState().value) {
                is MovieViewModel.State.Error -> {
                    Text(state.error, Modifier.fillMaxSize())
                }

                MovieViewModel.State.Loading -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.Gray)
                            .padding(10.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        ProgressIndicator()
                    }
                }

                is MovieViewModel.State.Data -> {
                    Column(
                        modifier = Modifier
                            .padding(it)
                            .background(Color.Gray)
                            .padding(2.dp)
                    ) {
                        LazyColumn(
                            modifier = Modifier.fillMaxHeight(),
                            verticalArrangement = Arrangement.spacedBy(1.dp)
                        ) {
                            items(state.data) { movie ->
                                MovieItemRow(
                                    model = movie,
                                    navigateToMovieDetails
                                ) { updatedMovieData ->
                                    selectedMovieData = updatedMovieData
                                    navigateToDetails(
                                        selectedMovieData!!.title,
                                        selectedMovieData!!.poster_path
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MovieItemRow(
    model: MovieData, onClick: (String, String) -> Unit,
    onItemClicked: (MovieData) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .background(colorResource(id = R.color.col_063041))
            .padding(5.dp)
    ) {
        val imageUrl = RestConfig.BASE_IMAGE_URL + model.poster_path
        Log.i("Image Url", imageUrl)
        Image(
            painter = rememberAsyncImagePainter(imageUrl),
            contentDescription = model.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .padding(5.dp)
                .clickable { onClick(model.title, model.poster_path) }
//                .clickable(onClick = { onClick(model.title, model.poster_path) })
        )
        Text(
            text = model.title!!,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
            modifier = Modifier
                .padding(0.dp)
                .clickable(onClick = {
                    onItemClicked(model)
                })
        )
    }
}

