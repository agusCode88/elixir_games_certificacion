package com.example.elixirgamesapp.presentation.viewmodel.listvg

import android.util.Log
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


    fun getAllVideoGamesFromServer(){
       viewModelScope.launch {
            try {
                val response = useCase.getAllVideoGamesOnStock()
                if( response.isNotEmpty()){
                    useCase.saveAllVideoGamesDB(response)
                    response.forEach { videoGame ->
                        val detailResponse = useCase.getVideoGameByIdOnStock(videoGame.id)
                        useCase.saveDetailVideoGameDB(detailResponse)
                    }
                }
                videoGameList.value = response
            } catch (e: Exception){
                Log.e("MainActivity", "Not Network Connecction")
                videoGameList.value = useCase.getAllVideoGamesDB()
            }
       }
    }
}