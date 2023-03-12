package com.swasi.composeplayground.play.moviedb.tvshow

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.swasi.composeplayground.network.MovieDbApiService
import com.swasi.composeplayground.network.response.PopularTvResults
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * Created by Sibaprasad Mohanty on 11/03/2023.
 * siba.x.prasad@gmail.com
 */


@HiltViewModel
class TvShowViewModel @Inject constructor(private val apiService: MovieDbApiService) : ViewModel() {
    var isLoading = mutableStateOf(false)
    var movieListResponse: List<PopularTvResults> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")
    fun getPopularTvShowList() {
        isLoading.value = true
        viewModelScope.launch {
            try {
                val movieList = apiService.getPopularTvShows(1)
                movieListResponse = movieList.results
                isLoading.value = false
                Log.i("Compose", "Tv SHow Response $movieListResponse")
            } catch (e: Exception) {
                errorMessage = e.message.toString()
                isLoading.value = false
            }
        }
    }
}