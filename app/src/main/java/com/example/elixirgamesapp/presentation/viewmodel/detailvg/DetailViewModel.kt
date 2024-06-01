package com.example.elixirgamesapp.presentation.viewmodel.detailvg

import android.util.Log
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
            try{
                val videoGame = useCase.getDetailVideoGameFromDB(idVideoGame)
                _videoGameDetail.value = videoGame
            }catch (e: Exception){
                Log.e("MainViewMODEL", "Not network connection")
                _videoGameDetail.value = useCase.getDetailVideoGameFromDB(idVideoGame)
            }

        }
    }

}