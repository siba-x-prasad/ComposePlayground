package com.swasi.composeplayground.play.moviedb.fruit

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.gson.Gson
import com.swasi.composeplayground.navigation.common.DefaultButton
import com.swasi.composeplayground.ui.theme.ComposePlaygroundTheme
import swasi.android.ui.components.AppText

/**
 * Created by Sibaprasad Mohanty on 20/03/2023.
 * siba.x.prasad@gmail.com
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FruitDetailsScreen(
    fruitDataInJson: String?,
    popBackStack: () -> Unit,
    popUpToLogin: () -> Unit
) {

    val fruitData = Gson().fromJson(fruitDataInJson, FruitData::class.java)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row {
                        Text(
                            "Fruit Details",
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
                        DefaultButton(
                            text = "Back",
                            onClick = popBackStack
                        )

                        DefaultButton(
                            text = "Log Out",
                            onClick = popUpToLogin
                        )

                        Image(
                            painter = painterResource(fruitData.image),
                            contentDescription = fruitData.fruitName,
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .fillMaxSize(0.5F)
                        )
                        AppText(
                            text = fruitData.fruitName,
                            size = 20.sp,
                            textColor = Color.Blue
                        )
                    }
                }
            }
        })
}