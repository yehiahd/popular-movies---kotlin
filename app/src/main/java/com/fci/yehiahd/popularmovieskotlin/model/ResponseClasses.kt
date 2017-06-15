package com.fci.yehiahd.popularmovieskotlin.model

import com.google.gson.annotations.SerializedName

/**
 * Created by yehia on 15/06/17.
 */
data class Movie(@SerializedName("vote_count") val voteCount: Int
                 , val id: Int
                 , @SerializedName("vote_average") val voteAvg: Double
                 , val title: String
                 , val popularity: Double
                 , @SerializedName("poster_path") val posterPath: String
                 , val overview: String
                 , @SerializedName("release_date") val releaseDate: String)

data class MoviesResponse(@SerializedName("results") val list: List<Movie>)