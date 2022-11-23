package com.firstapp.hilocardgameapp

import android.media.Image
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class GameActivity : AppCompatActivity() {

    lateinit var showNumber: TextView
    lateinit var scoreStreak: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_activity)


        showNumber = findViewById(R.id.showNumberView)
        val arrowsUpDown = findViewById<ImageView>(R.id.arrowUpDown)


        scoreStreak = findViewById(R.id.scoreStreak)
        val showScoreStreak = scoreStreak.text.toString().toIntOrNull()

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        //Back button to go back to main menu(activity 1)

        val higherButton = findViewById<Button>(R.id.higherButton)
        val lowerButton = findViewById<Button>(R.id.lowerButton)
        val startGameButton = findViewById<Button>(R.id.startGameButton)

        startGameButton.setOnClickListener {
            higherButton.visibility = View.VISIBLE
            lowerButton.visibility = View.VISIBLE
            arrowsUpDown.visibility = View.VISIBLE
            startGameButton.visibility = View.INVISIBLE
            randomCardShuffle()
        }

        higherButton.setOnClickListener {
            randomCardShuffle()

        }

        lowerButton.setOnClickListener {
            randomCardShuffle()
        }
    }

    fun randomNumber(): Int {
        val random = (1..13).random()
        showNumber.text = random.toString()
        return random
    }

    private fun randomCardShuffle() {

        val random = randomNumber()
        val showCard: ImageView = findViewById(R.id.aceOfSpades)
        val higherButton = findViewById<Button>(R.id.higherButton)

        when (random) {
            1 -> showCard.setImageResource(R.drawable.ace_of_spades2)
            2 -> showCard.setImageResource(R.drawable.two_of_diamonds)
            3 -> showCard.setImageResource(R.drawable.eight_of_clubs)
            4 -> showCard.setImageResource(R.drawable.four_of_clubs)
            5 -> showCard.setImageResource(R.drawable.five_of_spades)
            6 -> showCard.setImageResource(R.drawable.six_of_diamonds)
            7 -> showCard.setImageResource(R.drawable.seven_of_hearts)
            8 -> showCard.setImageResource(R.drawable.eight_of_clubs)
            9 -> showCard.setImageResource(R.drawable.nine_of_spades)
            10 -> showCard.setImageResource(R.drawable.ten_of_diamonds)
            11 -> showCard.setImageResource(R.drawable.jack_of_hearts2)
            12 -> showCard.setImageResource(R.drawable.queen_of_clubs2)
            13 -> showCard.setImageResource(R.drawable.king_of_clubs2)
        }
    }

    fun userHigherLower() {

        val higherButton = findViewById<Button>(R.id.higherButton)
        val userChoose = Int

        if (higherButton.equals(userChoose)) {
            Log.d("!!!", "True")
        }
    }
}
