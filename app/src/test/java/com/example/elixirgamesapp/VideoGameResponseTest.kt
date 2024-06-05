package com.example.elixirgamesapp

import com.example.elixirgamesapp.data.response.VideoGameResponse
import com.google.gson.Gson
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class VideoGameResponseTest {

    lateinit var videoGame: VideoGameResponse

    @Before
    fun setup(){
        videoGame = VideoGameResponse(
            id = 1,
            name = "Video Juego",
            released = "2024-06-04",
            background_image = "http.//example.org/image.png",
            rating = 4.2,
            metacritic = 90
        )
    }
    @Test
    fun `testear la creacion de la entidad`(){

        assertEquals(1,videoGame.id)
        assertEquals("Video Juego", videoGame.name)
        assertEquals("2024-06-04",videoGame.released)
        assertEquals("http.//example.org/image.png",videoGame.background_image)
        assertEquals(4.2,videoGame.rating, 0.001)
        assertEquals(90, videoGame.metacritic)

    }

    @Test
    fun `testear deserealizacion del JSON`(){
        val json = """
           {
                "id": 3498, 
                "name": "Grand Theft Auto V", 
                "released": "2013-09-17", 
                "background_image": 
                "https://media.rawg.io/media/games/84d/84da2ac3fdfc6507807a1808595afb12.jpg", 
                "rating": 4.48, 
                "metacritic": 97
              
             }
              """

        val videoGameJson = Gson().fromJson(json, VideoGameResponse::class.java)

        assertEquals(3498,videoGameJson.id)
        assertEquals("Grand Theft Auto V",videoGameJson.name)
        assertEquals("2013-09-17",videoGameJson.released)
        assertEquals("https://media.rawg.io/media/games/84d/84da2ac3fdfc6507807a1808595afb12.jpg",videoGameJson.background_image)
        assertEquals(4.48,videoGameJson.rating, 0.001)
        assertEquals(97, videoGameJson.metacritic)

    }
}