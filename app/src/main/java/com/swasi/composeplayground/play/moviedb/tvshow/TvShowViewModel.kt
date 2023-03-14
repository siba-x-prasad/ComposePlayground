package com.swasi.composeplayground.play.moviedb.tvshow

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.swasi.composeplayground.R
import com.swasi.composeplayground.network.MovieDbApiService
import com.swasi.composeplayground.network.response.ItemResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * Created by Sibaprasad Mohanty on 11/03/2023.
 * siba.x.prasad@gmail.com
 */


@HiltViewModel
class TvShowViewModel @Inject constructor(private val apiService: MovieDbApiService) : ViewModel() {
    var isLoading = mutableStateOf(false)
    var movieListResponse: List<ItemResult> by mutableStateOf(listOf())
    var fruitList: List<FruitData> = getFruitListFromServer()
    var errorMessage: String by mutableStateOf("")

    sealed class State {
        object Loading : State()
        object Error : State()
        data class Data(val data: List<ItemResult>) : State()
    }

    private var _tvSHowState = MutableStateFlow<State>(State.Loading)
    val tvShowState = _tvSHowState.asStateFlow()

    private val _fruitList = mutableStateListOf<FruitData>()
    val fruitListList: List<FruitData>
        get() = _fruitList

    fun getPopularTvShowList() {
        isLoading.value = true
        viewModelScope.launch {
            try {
                val movieList = apiService.getPopularTvShowsByFlow(page = 1)
                movieListResponse = movieList.results
                _tvSHowState.value = State.Data(movieList.results)
                isLoading.value = false
                Log.i("Compose", "Tv SHow Response $movieListResponse")
            } catch (e: Exception) {
                errorMessage = e.message.toString()
                isLoading.value = false
            }
        }
    }

    private fun getFruitListFromServer(): MutableList<FruitData> {
        val fruitsList = mutableListOf<FruitData>()
        fruitsList.add(FruitData("Apple", R.drawable.apple))
        fruitsList.add(FruitData("Orange", R.drawable.orange))
        fruitsList.add(FruitData("Banana", R.drawable.banana))
        fruitsList.add(FruitData("Strawberry", R.drawable.strawberry))
        fruitsList.add(FruitData("Mango", R.drawable.mango))
        fruitsList.add(FruitData("pomegranate", R.drawable.pomegranate))
        fruitsList.add(FruitData("Grapes", R.drawable.grapes))
        fruitsList.add(FruitData("Avocado", R.drawable.avocado))
        fruitsList.add(FruitData("Pears", R.drawable.pears))
        fruitsList.add(FruitData("Kiwi", R.drawable.kiwi))
        fruitsList.add(FruitData("Jack fruit", R.drawable.jackfruit))
        fruitsList.add(FruitData("Pine Apple", R.drawable.pineapple))
        return fruitsList
    }

    fun fetchFruitList() {
        viewModelScope.launch {
            isLoading.value = true
            delay(5000L)
            try {
                isLoading.value = false
                _fruitList.addAll(getFruitListFromServer())
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }

}