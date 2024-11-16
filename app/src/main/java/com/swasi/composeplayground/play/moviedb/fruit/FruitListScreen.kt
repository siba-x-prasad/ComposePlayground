package com.swasi.composeplayground.play.moviedb.fruit

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.gson.Gson
import com.swasi.composeplayground.R
import com.swasi.composeplayground.play.state.UiState
import swasi.android.ui.components.ProgressIndicator
import swasi.android.ui.theme.Colors

/**
 * Created by Sibaprasad Mohanty on 14/03/2023.
 * siba.x.prasad@gmail.com
 */


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FruitListScreen(
    viewModel: FruitListViewModel = hiltViewModel(),
    navigateToFruitDetails: (String) -> Unit,
    navigateToHomeScreen: () -> Unit
) {

    LaunchedEffect(Unit, block = {
        viewModel.loadFruits()
    })

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row {
                        Text(
                            "Fruit List",
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
                        navigateToHomeScreen()
                    }) {
                        Icon(
                            Icons.Outlined.Home,
                            "Home"
                        )
                    }

                    IconButton(onClick = {

                    }) {
                        Icon(
                            Icons.Outlined.ArrowBack,
                            "Movie"
                        )
                    }

                    IconButton(
                        onClick = {

                        }) {
                        Icon(
                            Icons.Outlined.AccountCircle,
                            "Favorite"
                        )
                    }

                })
        }
    ) {

        when (val state = viewModel.fruitListState.collectAsState().value) {
            is UiState.Error -> {
                Text(state.message, Modifier.fillMaxSize())
            }
            UiState.Loading -> {
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
            is UiState.Data -> {
                Log.i("TAG", "FruitListScreen: Size = ${state.value.size}")
                FruitList(
                    state.value,
                    navigateToFruitDetails,
                    modifier = Modifier.padding(it)
                ) {
                    viewModel.loadFruits()
                }
            }
        }
    }
}

@Composable
fun FruitList(
    listFruit: List<FruitData>,
    onClick: (String) -> Unit,
    modifier: Modifier,
    loadFruitData: () -> Unit
) {

    val threshold = 3
    val lastIndex = listFruit.lastIndex

    Column(
        modifier = Modifier
            .composed { modifier }
            .background(Color.Gray)
            .padding(2.dp)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(1.dp)
        ) {
            items(
                count = listFruit.size + 1,
                key = { listFruit.getOrNull(it)?.fruitName ?: "Hello" }
            ) { index ->

                val fruit = listFruit.getOrNull(index)

                if (fruit != null) {
                    Log.i("TAG", "FruitList: index = $index lastIndex $lastIndex")
                    if (index + threshold >= lastIndex) {
                        SideEffect {
                            loadFruitData()
                        }
                    }
                    FruitItemRow(
                        model = fruit
                    ) { selectedFruit ->
                        onClick(
                            selectedFruit
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun FruitItemRow(model: FruitData, onClick: (String) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .background(colorResource(id = R.color.col_063041))
            .clickable {
                val fruitDataInJson = Gson().toJson(model)
                onClick(fruitDataInJson)
            }
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
