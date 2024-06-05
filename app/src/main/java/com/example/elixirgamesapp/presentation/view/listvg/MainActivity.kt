package com.example.elixirgamesapp.presentation.view.listvg

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.elixirgamesapp.data.local.database.AppDataBase
import com.example.elixirgamesapp.data.network.api.VideoGameService
import com.example.elixirgamesapp.data.network.retrofit.RetrofitHelper
import com.example.elixirgamesapp.data.repository.VideoGameImpl
import com.example.elixirgamesapp.databinding.ActivityMainBinding
import com.example.elixirgamesapp.domain.VideoGameUseCase
import com.example.elixirgamesapp.presentation.view.detailvg.DetailActivity
import com.example.elixirgamesapp.presentation.viewmodel.listvg.VideoGameViewModel
import com.example.elixirgamesapp.presentation.viewmodel.listvg.ViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val apiService = RetrofitHelper.getRetrofit().create(VideoGameService::class.java)
        val dataBase = AppDataBase.getDatabase(application)

        val repository = VideoGameImpl(apiService, dataBase.videoGameDAO())
        val useCase = VideoGameUseCase(repository)

        val viewModelFactory = ViewModelFactory(useCase)
        val viewModel = ViewModelProvider(this,viewModelFactory)[VideoGameViewModel::class.java]

        viewModel.getAllVideoGamesFromServer()

        val adapterVideoGame = VideoGameAdapter()
        binding.vgRecycler.adapter = adapterVideoGame
        binding.vgRecycler.layoutManager = LinearLayoutManager(this)

        viewModel.videoGameLV.observe(this){
            Log.i("GAMES",it.toString())
            adapterVideoGame.videoGames = it
        }

        adapterVideoGame.onItemClickListener = { videoGame ->
            val idVideoGame = videoGame.id
            //TODO Hacer que esto vaya a mi segunda actividd o fragmento
            goToVideoGameDetailPage(idVideoGame)

        }
    }

    private fun goToVideoGameDetailPage(idVideoGame: Long ){
        val intent = Intent(this, DetailActivity::class.java).apply{
            putExtra("ID_VIDEO_GAME", idVideoGame)
        }
        startActivity(intent)
    }
}