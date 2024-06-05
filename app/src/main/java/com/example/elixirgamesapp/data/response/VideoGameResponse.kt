package com.example.elixirgamesapp.data.response

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "videogames")
data class VideoGameResponse(
    @PrimaryKey
    val id: Long,
    val name: String,
    val released: String,
    val background_image: String,
    val metacritic: Long,
    val rating: Double
) {}