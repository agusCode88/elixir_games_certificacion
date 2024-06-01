package com.example.elixirgamesapp.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.elixirgamesapp.data.response.VideoGameDetailResponse
import com.example.elixirgamesapp.data.response.VideoGameResponse
import retrofit2.Response

@Dao
interface VideoGameDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVideoGames(videoGames: MutableList<VideoGameResponse>)

    @Query("SELECT * FROM videogames")
    suspend fun getAllVideoGames(): MutableList<VideoGameResponse>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVideoGameDetail(videoGameDetail: VideoGameDetailResponse)

    @Query("SELECT * FROM videogame_details WHERE id = :id")
    suspend fun getVideoGameDetailById(id: Long): VideoGameDetailResponse
}