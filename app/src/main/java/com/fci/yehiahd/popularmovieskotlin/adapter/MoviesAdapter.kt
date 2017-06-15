package com.fci.yehiahd.popularmovieskotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.fci.yehiahd.popularmovieskotlin.R
import com.fci.yehiahd.popularmovieskotlin.model.Movie
import com.fci.yehiahd.popularmovieskotlin.model.MoviesResponse
import com.squareup.picasso.Picasso

/**
 * Created by yehia on 15/06/17.
 */
class MoviesAdapter(val response: MoviesResponse) : RecyclerView.Adapter<MoviesAdapter.MoviesHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MoviesHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesHolder, position: Int) {
        holder.bindMovie(response.list[position])
    }

    override fun getItemCount(): Int = response.list.size

    class MoviesHolder(view: View) : RecyclerView.ViewHolder(view) {
        val img = view.findViewById(R.id.movie_poster_img_view) as ImageView
        fun bindMovie(movie: Movie) {
            with(movie) {
                Picasso.with(itemView.context).load("http://image.tmdb.org/t/p/w185/${movie.posterPath}")
                        .resize(360, 600)
                        .into(img)
                itemView.setOnClickListener { Toast.makeText(itemView.context, "${movie.title} is Clicked!", Toast.LENGTH_SHORT).show() }
            }
        }
    }
}