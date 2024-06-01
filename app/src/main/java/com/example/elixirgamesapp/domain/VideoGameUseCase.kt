package com.example.elixirgamesapp.domain

import com.example.elixirgamesapp.data.repository.VideoGameImpl
import com.example.elixirgamesapp.data.repository.VideoGameRepository
import com.example.elixirgamesapp.data.response.VideoGameDetailResponse
import com.example.elixirgamesapp.data.response.VideoGameResponse

class VideoGameUseCase(private val repository: VideoGameImpl) {
    suspend fun getAllVideoGamesOnStock(): MutableList<VideoGameResponse>{
        return repository.fetchVideoGames()
    }
    suspend fun getVideoGameByIdOnStock(idVideogame: Long): VideoGameDetailResponse{
        return repository.fetchVideoGameById(idVideogame)
    }

    suspend fun saveAllVideoGamesOnStockDB(videoGames: MutableList<VideoGameResponse>){
        return repository.saveAllVideoGamesDB(videoGames)
    }

    suspend fun getAllVideoGamesFromDB(): MutableList<VideoGameResponse>{
        return repository.getVideoGamesDB()
    }

    suspend fun saveDetailVideoGameOnDB(videoGameDetail: VideoGameDetailResponse){
        return repository.saveDetailVideoGameDB(videoGameDetail)
    }

    suspend fun getDetailVideoGameFromDB(idVideoGame: Long): VideoGameDetailResponse{
        return repository.getDetailVideoGameDB(idVideoGame)
    }
}