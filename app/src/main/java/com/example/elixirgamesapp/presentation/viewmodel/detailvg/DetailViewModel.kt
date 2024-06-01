package com.example.elixirgamesapp.presentation.viewmodel.detailvg

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.elixirgamesapp.data.response.VideoGameDetailResponse
import com.example.elixirgamesapp.domain.VideoGameUseCase
import kotlinx.coroutines.launch

class DetailViewModel(private val useCase: VideoGameUseCase): ViewModel() {

    private val _videoGameDetail = MutableLiveData<VideoGameDetailResponse>()
            val videoGameDetailLV: MutableLiveData<VideoGameDetailResponse>
                get() = _videoGameDetail

    fun getDetailVideoGameById(idVideoGame: Long){
        viewModelScope.launch {
            val videoGame = useCase.getVideoGameByIdOnStock(idVideoGame)
            _videoGameDetail.value = videoGame
        }
    }

}