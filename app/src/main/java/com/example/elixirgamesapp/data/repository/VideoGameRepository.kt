package com.example.elixirgamesapp.data.repository

import com.example.elixirgamesapp.data.response.VideoGameDetailResponse
import com.example.elixirgamesapp.data.response.VideoGameResponse

interface VideoGameRepository {

    /**
     * Estos son los métodos para poder trabajar con el servicio de API REST
     */
    suspend fun fetchVideoGames(): MutableList<VideoGameResponse>
    suspend fun fetchVideoGameById(idVideoGameService: Long) : VideoGameDetailResponse

    /**
     * Estos son los métodos para poder trabajar con la base de datos y que la app
     * se pueda utilizar sin conexión
     */
    suspend fun saveAllVideoGamesOnDB(videoGames: MutableList<VideoGameResponse>)
    suspend fun getAllVideoGamesFromDB(): MutableList<VideoGameResponse>
    suspend fun saveDetailVideoGameOnDB(detailVideoGameDetailResponse: VideoGameDetailResponse)
    suspend fun getDetailVideoGameFromDB(idVideoFGame: Long): VideoGameDetailResponse

}