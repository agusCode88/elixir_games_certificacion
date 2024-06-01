package com.example.elixirgamesapp.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

data class VideoGameDetail(
    @PrimaryKey
    val id: Long,
    val playtime: Long,
    val platforms: String,
    val genres: String,
    val format: String,
    val price: Double,
    val lastPrice: Double,
    val delivery: Boolean
)