package com.example.elixirgamesapp.presentation.viewmodel.detailvg

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.elixirgamesapp.domain.VideoGameUseCase

class ViewModelDetailFactory(private val videoGamesUseCase: VideoGameUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(videoGamesUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}