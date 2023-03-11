package com.swasi.composeplayground.play.moviedb

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.swasi.composeplayground.play.moviedb.navigation.MovieNavGraph
import com.swasi.composeplayground.ui.theme.ComposePlaygroundTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDbActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
private fun MainScreen() {
    ComposePlaygroundTheme() {
        val navController = rememberNavController()
        MovieNavGraph(navController)
    }
}