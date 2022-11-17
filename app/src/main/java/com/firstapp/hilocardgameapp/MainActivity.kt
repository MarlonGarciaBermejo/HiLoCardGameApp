package com.firstapp.hilocardgameapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.rulesButton)
        button.setOnClickListener{
            val intent1 = Intent(this, InfoActivity::class.java)
            startActivity(intent1)
        }
        val buttonClick = findViewById<Button>(R.id.startButton)
        buttonClick.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)

            startActivity(intent)
        }
    }
}
