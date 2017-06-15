package com.fci.yehiahd.popularmovieskotlin.controller.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.fci.yehiahd.popularmovieskotlin.R
import com.fci.yehiahd.popularmovieskotlin.adapter.MoviesAdapter
import com.fci.yehiahd.popularmovieskotlin.api.Request
import org.jetbrains.anko.async
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {
    var moviesRecycler: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        moviesRecycler = findViewById(R.id.movies_recycler) as RecyclerView
        moviesRecycler!!.layoutManager = GridLayoutManager(this, 2)
        getMoviesJsonStr()
    }

    private fun getMoviesJsonStr() {
        async {
            val moviesResponse = Request().run()
            uiThread { moviesRecycler!!.adapter = MoviesAdapter(moviesResponse) }
        }
    }
}
