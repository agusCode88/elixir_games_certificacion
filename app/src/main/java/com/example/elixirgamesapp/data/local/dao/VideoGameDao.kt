package com.example.elixirgamesapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.elixirgamesapp.data.response.VideoGameDetailResponse
import com.example.elixirgamesapp.data.response.VideoGameResponse

@Dao
interface VideoGameDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVideoGames(videoGameResponse: MutableList<VideoGameResponse>)
    @Query("SELECT * FROM videogames")
    suspend fun getAllVideoGames(): MutableList<VideoGameResponse>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVideoGameDetail(videoGameDetail: VideoGameDetailResponse)
    @Query("SELECT * FROM videogame_details WHERE id = :idVideGame")
    suspend fun getVideoGameDetailById(idVideGame: Long): VideoGameDetailResponse

}