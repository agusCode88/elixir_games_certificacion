package com.example.elixirgamesapp.data.local.database


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.elixirgamesapp.data.local.dao.VideoGameDao
import com.example.elixirgamesapp.data.response.VideoGameDetailResponse
import com.example.elixirgamesapp.data.response.VideoGameResponse

@Database(entities = [VideoGameResponse::class, VideoGameDetailResponse::class], version = 1, exportSchema = false)
abstract class AppDataBase: RoomDatabase() {
    abstract fun videoGameDAO(): VideoGameDao
    companion object {
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getDatabase(context: Context): AppDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "videoGame_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

}