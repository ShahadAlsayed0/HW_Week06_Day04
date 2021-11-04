package com.sumaya.hw_week06_day04.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.sumaya.hw_week06_day04.R

class MainActivity : AppCompatActivity() {
    private lateinit var recyView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel =
            ViewModelProvider(this).get(ViewModel::class.java)
        recyView = findViewById(R.id.rv)
        recyView.layoutManager = StaggeredGridLayoutManager(
            1,
            StaggeredGridLayoutManager.VERTICAL
        )  //GridLayoutManager(this, 2)

        viewModel.fetchInterestingList().observe(this, {
            recyView.adapter = YoutubeAdapter(it.videos)
            Log.d("Flickr Main Response", it.videos.toString())
        })
    }
}