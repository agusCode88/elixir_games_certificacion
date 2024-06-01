package com.example.elixirgamesapp.data.network.api

import com.example.elixirgamesapp.data.response.VideoGameDetailResponse
import com.example.elixirgamesapp.data.response.VideoGameResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface VideoGameService {
    @GET("games")
    suspend fun getAllVideoGames(): MutableList<VideoGameResponse>

    @GET("gameDetails/{id}")
    suspend fun getVideoGameById(@Path("id") idVideoGame: Long ) : VideoGameDetailResponse
}