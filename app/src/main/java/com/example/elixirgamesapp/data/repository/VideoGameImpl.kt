package com.example.elixirgamesapp.data.repository

import com.example.elixirgamesapp.data.local.daos.VideoGameDao
import com.example.elixirgamesapp.data.network.api.VideoGameService
import com.example.elixirgamesapp.data.response.VideoGameDetailResponse
import com.example.elixirgamesapp.data.response.VideoGameResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class VideoGameImpl(
    private var apiservice:VideoGameService,
    private var daoDB: VideoGameDao
): VideoGameRepository {
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

    override suspend fun saveAllVideoGamesDB(videoGames: MutableList<VideoGameResponse>) {
        return withContext(Dispatchers.IO){
            daoDB.insertVideoGames(videoGames)
        }
    }

    override suspend fun getVideoGamesDB(): MutableList<VideoGameResponse> {
        return withContext(Dispatchers.IO){
            val videoGamesBD = daoDB.getAllVideoGames()
            videoGamesBD
        }
    }

    override suspend fun saveDetailVideoGameDB(videoGameDetails: VideoGameDetailResponse) {
        return withContext(Dispatchers.IO){
           daoDB.insertVideoGameDetail(videoGameDetails)
        }
    }

    override suspend fun getDetailVideoGameDB(idVideoGame: Long): VideoGameDetailResponse {
        return withContext(Dispatchers.IO){
            val videoGameDetailBD = daoDB.getVideoGameDetailById(idVideoGame)
            videoGameDetailBD
        }
    }
}