package com.firstapp.hilocardgameapp


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity



class PointsActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.points_activity)

        val sharedPref = getSharedPreferences("game", Context.MODE_PRIVATE)
        val textView = findViewById<TextView>(R.id.scoreStreak)

        val playButton = findViewById<Button>(R.id.playAgainButton)
        playButton.setOnClickListener {
            val intent1 = Intent(this, GameActivity::class.java)
            startActivity(intent1)
        }
        val exitButton = findViewById<Button>(R.id.exitButton)
        exitButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val hiScore = sharedPref.getInt("hiscore", 0)
        textView.text = hiScore.toString()


    }
}
