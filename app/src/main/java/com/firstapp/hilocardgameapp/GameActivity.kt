package com.firstapp.hilocardgameapp
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_activity)
        
          supportActionBar!!.setDisplayHomeAsUpEnabled(true)
          //Back button to go back to main menu(activity 1)
    }
}
