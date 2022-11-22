package com.firstapp.hilocardgameapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class PointsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.points_activity)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }
}