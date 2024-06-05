package com.example.elixirgamesapp.data.response

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "videogame_details")
data class VideoGameDetailResponse(
   @PrimaryKey
    val id: Long,
    val name: String,
    val released: String,
    @SerializedName("background_image")
    val backgroundImage: String,
    val metacritic: Long,
    val rating: Double,
    val playtime: Long,
    val platforms: String,
    val genres: String,
    val format: String,
    val price: Double,
    val lastPrice: Double,
    val delivery: Boolean
) {}


