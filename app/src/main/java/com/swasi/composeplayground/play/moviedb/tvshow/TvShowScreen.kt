package com.swasi.composeplayground.play.moviedb.tvshow

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.swasi.composeplayground.R
import com.swasi.composeplayground.components.ProgressIndicator
import com.swasi.composeplayground.network.RestConfig
import com.swasi.composeplayground.network.response.ItemResult

/**
 * Created by Sibaprasad Mohanty on 11/03/2023.
 * siba.x.prasad@gmail.com
 */

@Composable
fun TvShowScreen(viewModel: TvShowViewModel = hiltViewModel()) {
    LaunchedEffect(Unit, block = {
        viewModel.fetchFruitList()
        viewModel.getPopularTvShowList()
    })
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row {
                        Text(
                            "Popular Tv Show",
                            color = Color.White
                        )
                    }
                })
        },
        content = {
            when (val state = viewModel.tvShowState.collectAsState().value) {
                TvShowViewModel.State.Error -> {
                    Text("Error", Modifier.fillMaxSize())
                }
                TvShowViewModel.State.Loading -> {
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
                is TvShowViewModel.State.Data -> {
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
                            items(state.data) { fruit ->
                                TvShowItemRow(fruit)
                            }
                        }
                    }
                }
            }
        }
    )
}

data class FruitData(val fruitName: String, val image: Int)

@Composable
fun TvShowList(fruitList: MutableList<ItemResult>) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(fruitList) { model ->
            TvShowItemRow(model = model)
        }
    }
}

@Composable
fun TvShowItemRow(model: ItemResult) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .background(colorResource(id = R.color.col_063041))
            .padding(5.dp)
    ) {
        val imageUrl = RestConfig.BASE_IMAGE_URL + model.posterPath
        Log.i("Image Url", imageUrl)
        Image(
            painter = rememberAsyncImagePainter(imageUrl),
            contentDescription = model.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .padding(5.dp)
        )
        Text(
            text = model.name!!,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )
    }
}

@Composable
fun FruitItemRow(model: FruitData) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .background(colorResource(id = R.color.col_063041))
            .padding(5.dp)
    ) {
        Image(
            painter = painterResource(id = model.image),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .padding(5.dp)
        )
        Text(
            text = model.fruitName,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )
    }
}