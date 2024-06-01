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
}