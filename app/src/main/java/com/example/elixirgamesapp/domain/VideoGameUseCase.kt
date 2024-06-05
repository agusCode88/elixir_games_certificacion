package com.example.elixirgamesapp.domain

import com.example.elixirgamesapp.data.repository.VideoGameImpl
import com.example.elixirgamesapp.data.response.VideoGameDetailResponse
import com.example.elixirgamesapp.data.response.VideoGameResponse


class VideoGameUseCase(private val repository: VideoGameImpl) {
    suspend fun getAllVideoGamesOnStock(): MutableList<VideoGameResponse>{
        return repository.fetchVideoGames()
    }
    suspend fun getVideoGameByIdOnStock(idVideogame: Long): VideoGameDetailResponse{
        return repository.fetchVideoGameById(idVideogame)
    }


    suspend fun saveAllVideoGamesDB(videoGames: MutableList<VideoGameResponse>) {
            return repository.saveAllVideoGamesOnDB(videoGames)
    }

    suspend fun getAllVideoGamesDB(): MutableList<VideoGameResponse>{
        return repository.getAllVideoGamesFromDB()
    }

    suspend fun saveDetailVideoGameDB(videoGameDetail: VideoGameDetailResponse){
        return repository.saveDetailVideoGameOnDB(videoGameDetail)
    }

    suspend fun getDetailVideoGameDB(idVideoGame: Long): VideoGameDetailResponse{
        return repository.getDetailVideoGameFromDB(idVideoGame)
    }

}