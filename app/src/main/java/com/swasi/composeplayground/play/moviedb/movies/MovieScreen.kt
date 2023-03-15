package com.swasi.composeplayground.play.moviedb.movies

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
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
import com.swasi.composeplayground.components.AppButton
import com.swasi.composeplayground.components.ProgressIndicator
import com.swasi.composeplayground.network.RestConfig
import com.swasi.composeplayground.network.response.MovieData

/**
 * Created by Sibaprasad Mohanty on 14/03/2023.
 * siba.x.prasad@gmail.com
 */


@Composable
fun MovieScreen(
    viewModel: MovieViewModel = hiltViewModel(),
    navigateToMovieDetails: (String, String) -> Unit,
) {

    LaunchedEffect(Unit, block = {
        viewModel.getPopularMovies()
    })


//    var onClickForChild by remember {
//        mutableStateOf({})
//    }
//
//    LaunchedEffect(Unit, block = {
//
//    })
//
//    LaunchedEffect(key1 = ""){
//        viewModel.eventFlow.collectLatest {
//            when (it) {
//                is MovieData -> {
//                    navigateToMovieDetails(it.title, it.poster_path)
//                }
//            }
//        }
//    }

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
                })
        }
    ) {
        Column() {
            AppButton(text = "Movie Details", modifier = Modifier.fillMaxWidth()) {
                navigateToMovieDetails("Siba", "kjhkhkjhk")
            }
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
                                MovieItemRow(movie, navigateToMovieDetails)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MovieItemRow(model: MovieData, onClick: (String, String) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .background(colorResource(id = R.color.col_063041))
            .padding(5.dp)
            .clickable(onClick = { onClick(model.title, model.poster_path) })
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
        )
        Text(
            text = model.title!!,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )
    }
}
