package com.firstapp.hilocardgameapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class GameActivity : AppCompatActivity() {

    lateinit var scoreStreak: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_activity)

        val sharedPref = getSharedPreferences("game", Context.MODE_PRIVATE)
        val arrowsUpDown = findViewById<ImageView>(R.id.arrowUpDown)

        scoreStreak = findViewById<TextView>(R.id.scoreStreak)
        val highScoreText = findViewById<TextView>(R.id.highScoreText)


        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        //Back button to go back to main menu(activity 1)

        val button2 = findViewById<Button>(R.id.pointsButton)
        button2.setOnClickListener {
            val intent2 = Intent(this, PointsActivity::class.java)
            startActivity(intent2)
        }
        val higherButton = findViewById<Button>(R.id.higherButton)
        val lowerButton = findViewById<Button>(R.id.lowerButton)
        val startGameButton = findViewById<Button>(R.id.startGameButton)
        var lastCard = 0
        var score = 0



        startGameButton.setOnClickListener {        // Start game function

            highScoreText.visibility = View.VISIBLE
            scoreStreak.visibility = View.VISIBLE
            higherButton.visibility = View.VISIBLE
            lowerButton.visibility = View.VISIBLE
            arrowsUpDown.visibility = View.VISIBLE          // This is for the buttons to be invincible until you click start game
            startGameButton.visibility = View.INVISIBLE
            drawCard()


        }

        higherButton.setOnClickListener {           // HigherButton function using a if statement, the current card is lower or equal to next one you will then get a point etc.. same with LowerButton.
            val newCard = drawCard()
            if (lastCard <= newCard) {
                score++ // Score +
                val hiScore = sharedPref.getInt("hiscore", 0)
                if (score > hiScore) {
                    sharedPref.edit().apply {
                        this.putInt("hiscore", score)
                        commit()
                    }
                }
            } else {
                score = 0       // reset score to 0
            }
            lastCard = newCard
            scoreStreak.text = score.toString()
        }

        lowerButton.setOnClickListener {
            val newCard = drawCard()
            if (lastCard >= newCard) {
                score++
                val hiScore = sharedPref.getInt("hiscore", 0)
                if (score > hiScore) {
                    sharedPref.edit().apply {
                        this.putInt("hiscore", score)
                        commit()
                    }
                }
            } else {
                score = 0
            }
            lastCard = newCard
            scoreStreak.text = score.toString()
        }
    }

    private fun drawCard(): Int  {
        val random = (1..13).random()
        val showCard: ImageView =
            findViewById(R.id.cardBackSide)               // Random draw function for card deck
        when (random) {
            1 -> showCard.setImageResource(R.drawable.ace_of_spades2)
            2 -> showCard.setImageResource(R.drawable.two_of_diamonds)
            3 -> showCard.setImageResource(R.drawable.three_of_hearts)
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
        return random
    }
}
