package com.firstapp.hilocardgameapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PointsActivity : AppCompatActivity() {

    val player = mutableListOf<Player>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.points_activity)

        val recyclerView = findViewById<RecyclerView>(R.id.scoreRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = PlayerRecyclerAdapter(this, player)
        recyclerView.adapter = adapter

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }


}
