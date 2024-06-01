package com.example.elixirgamesapp.data.local.entities

import com.google.gson.annotations.SerializedName

data class VideoGame(
    val id: Long,
    val name: String,
    val released: String,
    @SerializedName("background_image")
    val backgroundImage: String,
    val metacritic: Long,
    val rating: Double,
)