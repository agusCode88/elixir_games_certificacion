package com.example.elixirgamesapp.presentation.view.detailvg

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.elixirgamesapp.R
import com.example.elixirgamesapp.data.local.database.AppDataBase
import com.example.elixirgamesapp.data.network.api.VideoGameService
import com.example.elixirgamesapp.data.network.retrofit.RetrofitHelper
import com.example.elixirgamesapp.data.repository.VideoGameImpl
import com.example.elixirgamesapp.databinding.ActivityDetailBinding
import com.example.elixirgamesapp.domain.VideoGameUseCase
import com.example.elixirgamesapp.presentation.viewmodel.detailvg.DetailViewModel
import com.example.elixirgamesapp.presentation.viewmodel.detailvg.ViewModelDetailFactory
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {

    private lateinit var bindingDetail: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingDetail = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(bindingDetail.root)

        val idVideogame  = intent.getLongExtra("ID_VIDEO_GAME", -1)
        if( idVideogame == -1L){
            finish()
        }

        val apiService = RetrofitHelper.getRetrofit().create(VideoGameService::class.java)
        val database = AppDataBase.getDatabase(application)
        val repository = VideoGameImpl(apiService,database.videoGameDao())
        val useCase = VideoGameUseCase(repository)
        val viewModelFactory = ViewModelDetailFactory(useCase)
        val viewModel = ViewModelProvider(this, viewModelFactory)[DetailViewModel::class.java]
       // Log.i()

        viewModel.getDetailVideoGameById(idVideogame)

        viewModel.videoGameDetailLV.observe(this){
           //TODO Cómo ya tengo datos , puedo pintar mi vista
            with(it){
                bindingDetail.txtNameVideoGame.text = name
                bindingDetail.ratingBar.rating = rating.toFloat()
                bindingDetail.txtReleasedVideoGame.text = released
                bindingDetail.txtGenre.text = genres
                bindingDetail.txtMetacritic.text = metacritic.toString()
                bindingDetail.txtPrice.text = price.toString()
                bindingDetail.txtLastPrice.text = lastPrice.toString()
                Picasso
                    .get()
                    .load(backgroundImage)
                    .into(bindingDetail.imgVideoGame)
            }

        }

    }
}