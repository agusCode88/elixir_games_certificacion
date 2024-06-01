package com.example.elixirgamesapp.presentation.viewmodel.listvg

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.elixirgamesapp.data.response.VideoGameResponse
import com.example.elixirgamesapp.domain.VideoGameUseCase
import kotlinx.coroutines.launch

class VideoGameViewModel(private val useCase: VideoGameUseCase): ViewModel() {

    private var videoGameList = MutableLiveData<MutableList<VideoGameResponse>>()

    val videoGameLV
        get() = videoGameList

    init {
        viewModelScope.launch {
            videoGameList.value = useCase.getAllVideoGamesOnStock()
        }
    }

}