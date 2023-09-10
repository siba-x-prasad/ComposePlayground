package com.swasi.composeplayground.play.moviedb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.swasi.composeplayground.appnav.appmoviedb.MovieNavGraph
import com.swasi.composeplayground.ui.theme.ComposePlaygroundTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDbActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
private fun MainScreen() {
//    val activity = LocalContext.current as Activity
//    LaunchedEffect(activity) {
//        activity.window.setBackgroundDrawable(BitmapDrawable)
//    }

    ComposePlaygroundTheme() {
        val navController = rememberNavController()
        MovieNavGraph(navController)
    }
}