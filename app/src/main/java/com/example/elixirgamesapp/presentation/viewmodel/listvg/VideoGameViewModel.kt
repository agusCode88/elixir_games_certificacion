package com.example.elixirgamesapp.presentation.viewmodel.listvg

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.elixirgamesapp.data.response.VideoGameResponse
import com.example.elixirgamesapp.domain.VideoGameUseCase
import kotlinx.coroutines.launch

class VideoGameViewModel(private val useCase: VideoGameUseCase) : ViewModel() {

    private var videoGameList = MutableLiveData<MutableList<VideoGameResponse>>()

    val videoGameLV
        get() = videoGameList


    fun getAllVideoGamesFromServer() {

        viewModelScope.launch {
            try {
                val response = useCase.getAllVideoGamesOnStock()
                if (response.isNotEmpty()) {
                    useCase.saveAllVideoGamesOnStockDB(response)
                    response.forEach { videoGame ->
                        val detail = useCase.getVideoGameByIdOnStock(videoGame.id)
                        useCase.saveDetailVideoGameOnDB(detail)
                    }
                }
                videoGameList.value = response
            } catch (e: Exception) {
                Log.e("MainViewMODEL", "Not network connection")
                videoGameList.value = useCase.getAllVideoGamesFromDB()

            }
        }
    }

}