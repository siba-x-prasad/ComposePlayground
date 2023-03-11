package com.swasi.composeplayground.network

import com.swasi.composeplayground.network.response.PopularTvShowResponse
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by Sibaprasad Mohanty on 11/03/2023.
 * siba.x.prasad@gmail.com
 */

interface MovieDbApiService {

    @GET("tv/popular?")
    suspend fun getPopularTvShows(page: Int): PopularTvShowResponse

    @GET("tv/popular")
    suspend fun getPopularTvShowsByFlow(
        @Query("api_key") apiKey: String = RestConfig.API_TOKEN,
        @Query("language") language: String = RestConfig.LANGUAGE,
        @Query("page") page: Int
    ): PopularTvShowResponse

}