package com.fci.yehiahd.popularmovieskotlin.api

import com.fci.yehiahd.popularmovieskotlin.model.MoviesResponse
import com.google.gson.Gson
import java.net.URL

/**
 * Created by yehia on 15/06/17.
 */
class Request {

    companion object {
        private val API_KEY = "a1192a18018e43a1fbd6a3cc003d0eac"
        private val BASE_URL = "http://api.themoviedb.org/3/movie/top_rated?api_key"
        private val COMPLETE_URL = "$BASE_URL=$API_KEY"
    }

    fun run(): MoviesResponse {
        val moviesJsonResponse = URL(COMPLETE_URL).readText()
        return Gson().fromJson(moviesJsonResponse, MoviesResponse::class.java)
    }
}