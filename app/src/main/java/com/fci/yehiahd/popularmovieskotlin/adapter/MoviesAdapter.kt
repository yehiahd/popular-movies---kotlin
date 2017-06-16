package com.fci.yehiahd.popularmovieskotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fci.yehiahd.popularmovieskotlin.R
import com.fci.yehiahd.popularmovieskotlin.model.Movie
import com.fci.yehiahd.popularmovieskotlin.model.MoviesResponse
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_movie.view.*

/**
 * Created by yehia on 15/06/17.
 */
class MoviesAdapter(val response: MoviesResponse, val itemClick: (Movie) -> Unit) : RecyclerView.Adapter<MoviesAdapter.MoviesHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesHolder {
        return MoviesHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false), itemClick)
    }

    override fun onBindViewHolder(holder: MoviesHolder, position: Int) {
        holder.bind(response[position])
    }

    override fun getItemCount(): Int = response.size()

    class MoviesHolder(view: View, val itemClick: (Movie) -> Unit) : RecyclerView.ViewHolder(view) {


        fun bind(movie: Movie) {
            with(movie) {
                Picasso.with(itemView.context).load("http://image.tmdb.org/t/p/w185/$posterPath")
                        .resize(360, 600)
                        .into(itemView.moviePosterImg)

                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }
}