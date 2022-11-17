package com.firstapp.hilocardgameapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val buttonClick = findViewById<Button>(R.id.startButton)
        buttonClick.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
    }
}
