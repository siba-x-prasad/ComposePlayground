package com.swasi.composeplayground.play.moviedb.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.swasi.composeplayground.network.MovieDbApiService
import com.swasi.composeplayground.network.response.MovieData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * Created by Sibaprasad Mohanty on 14/03/2023.
 * siba.x.prasad@gmail.com
 */


@HiltViewModel
class MovieViewModel @Inject constructor(private val apiService: MovieDbApiService) : ViewModel() {

    sealed class State {
        object Loading : State()
        data class Error(val error: String) : State()
        data class Data(val data: List<MovieData>) : State()
    }

    private var _movieListState = MutableStateFlow<State>(State.Loading)
    val movieListState = _movieListState.asStateFlow()


    fun getPopularMovies() {
        _movieListState.value = State.Loading
        viewModelScope.launch {
            try {
                val movieList = apiService.getPopularMovies()
                _movieListState.value = State.Data(movieList.results)
            } catch (e: Exception) {
                _movieListState.value = State.Error(e.message!!)
            }
        }
    }
}