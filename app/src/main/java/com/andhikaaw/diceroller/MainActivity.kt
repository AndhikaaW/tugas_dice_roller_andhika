package com.andhikaaw.diceroller

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

        val rollbutton: Button = findViewById(R.id.button2)
        rollbutton.setOnClickListener {
//            val toast = Toast.makeText(this, "Dice Teracak" , Toast.LENGTH_SHORT)
//            toast.show()

//            val resultTextView: TextView = findViewById(R.id.textView)
//            resultTextView.text = "6"

            rolldice()
            setIdentity()
        }
    }

    private fun rolldice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()

        val diceImage: ImageView = findViewById(R.id.imageView)
        diceImage.setImageResource(R.drawable.dice_2)

        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource)
    }

    fun setIdentity() {
        val name : TextView = findViewById(R.id.textView2)
        val nim : TextView = findViewById(R.id.textView3)
        val kelas : TextView = findViewById(R.id.textView4)

        name.text = "Andika Wahyu Agustian"
        nim.text = "223307090"
        kelas.text = "2D"
    }
}

class Dice (val numSides: Int){
    fun roll(): Int{
        return (1..numSides).random()
    }
}


