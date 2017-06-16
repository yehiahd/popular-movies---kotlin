package com.fci.yehiahd.popularmovieskotlin.controller.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import com.fci.yehiahd.popularmovieskotlin.R
import com.fci.yehiahd.popularmovieskotlin.adapter.MoviesAdapter
import com.fci.yehiahd.popularmovieskotlin.api.Request
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.async
import org.jetbrains.anko.longToast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        moviesRecycler.layoutManager = GridLayoutManager(this, 2)
        getMoviesJsonStr()
    }

    private fun getMoviesJsonStr() {
        async {
            val moviesResponse = Request().run()
            uiThread {
                moviesRecycler.adapter = MoviesAdapter(moviesResponse) { longToast(it.title) }
            }
        }
    }
}
