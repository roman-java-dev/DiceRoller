package com.example.diceroller

import android.app.ProgressDialog.show
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
            rollButton.setOnClickListener {
                val luckyNumber = 4
                when(rollDice()) {
                    luckyNumber -> Toast.makeText(this, "You won!", Toast.LENGTH_LONG).show()
                    1 -> Toast.makeText(this, "So sorry! You rolled a 1. Try again!", Toast.LENGTH_SHORT).show()
                    2 -> Toast.makeText(this, "Sadly, you rolled a 2. Try again!", Toast.LENGTH_SHORT).show()
                    3 -> Toast.makeText(this,"Unfortunately, you rolled a 3. Try again!", Toast.LENGTH_SHORT).show()
                    5 -> Toast.makeText(this,"Don't cry! You rolled a 5. Try again!", Toast.LENGTH_SHORT).show()
                    6 -> Toast.makeText(this,"Apologies! You rolled a 6. Try again!", Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun rollDice(): Int {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceImage: ImageView = findViewById(R.id.imageView)
        val drawableResource =  when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> {R.drawable.dice_6}
        }
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()
        return diceRoll
    }
}
class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}