package com.fci.yehiahd.popularmovieskotlin.model

import com.google.gson.annotations.SerializedName

/**
 * Created by yehia on 15/06/17.
 */
data class Movie(
        @SerializedName("vote_count") val voteCount: Int
        , @SerializedName("id") val id: Int
        , @SerializedName("vote_average") val voteAvg: Double
        , @SerializedName("title") val title: String
        , @SerializedName("popularity") val popularity: Double
        , @SerializedName("poster_path") val posterPath: String
        , @SerializedName("overview") val overview: String
        , @SerializedName("release_date") val releaseDate: String)

data class MoviesResponse(@SerializedName("results") val list: List<Movie>) {
    operator fun get(position: Int) = list[position]
    fun size() = list.size
}