package com.example.elixirgamesapp.data.repository

import com.example.elixirgamesapp.data.local.dao.VideoGameDao
import com.example.elixirgamesapp.data.network.api.VideoGameService
import com.example.elixirgamesapp.data.response.VideoGameDetailResponse
import com.example.elixirgamesapp.data.response.VideoGameResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class VideoGameImpl(
    private var apiservice:VideoGameService,
    private var daoDB: VideoGameDao
    ): VideoGameRepository {


    /**
     * Implementación de la API REST de videojuegos
     */
    override suspend fun fetchVideoGames(): MutableList<VideoGameResponse> {
       return withContext(Dispatchers.IO){
             val listVideoGames = apiservice.getAllVideoGames()
             listVideoGames
       }
    }

    override suspend fun fetchVideoGameById(idVideoGameService: Long): VideoGameDetailResponse {
        return withContext(Dispatchers.IO){
            val videoGameDetail = apiservice.getVideoGameById(idVideoGameService)
            videoGameDetail
        }
    }

    /**
     * Implementación de las consultas a la base de datos a través de un DAO
     */

    override suspend fun saveAllVideoGamesOnDB(videoGames: MutableList<VideoGameResponse>) {
        return withContext(Dispatchers.IO){
            daoDB.insertVideoGames(videoGames)
        }
    }

    override suspend fun getAllVideoGamesFromDB(): MutableList<VideoGameResponse> {
        return withContext(Dispatchers.IO){
            val response = daoDB.getAllVideoGames()
            response
        }

    }

    override suspend fun saveDetailVideoGameOnDB(detailVideoGameDetailResponse: VideoGameDetailResponse) {
        return withContext(Dispatchers.IO){
            daoDB.insertVideoGameDetail(detailVideoGameDetailResponse)
        }
    }

    override suspend fun getDetailVideoGameFromDB(idVideoGame: Long): VideoGameDetailResponse {
        return withContext(Dispatchers.IO){
            val response = daoDB.getVideoGameDetailById(idVideoGame)
            response
        }

    }
}