package com.swasi.composeplayground.appnav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.swasi.composeplayground.appnav.appmoviedb.MovieNavGraph

@Composable
fun AppMovieDbScreen() {
    val navController = rememberNavController()
    MovieNavGraph(navController)
}

@Composable
fun FeatureAccountScreen() {
    val navController = rememberNavController()
    AppNavGraph(navController)
}

@Composable
fun FeatureProfileScreen() {
    val navController = rememberNavController()
    MovieNavGraph(navController)
}

@Composable
fun FeatureHomeScreen() {
    val navController = rememberNavController()
    MovieNavGraph(navController)
}

@Composable
fun FeatureMovieDbScreen() {
    val navController = rememberNavController()
    MovieNavGraph(navController)
}

@Composable
fun FeatureSideEffectScreen() {
    val navController = rememberNavController()
    MovieNavGraph(navController)
}
