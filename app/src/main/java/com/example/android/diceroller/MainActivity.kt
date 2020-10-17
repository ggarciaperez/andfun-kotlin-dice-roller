/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text
import java.util.*

class MainActivity : AppCompatActivity() {
    //A container for the Images is declared
    lateinit var diceImage: ImageView

    //Added a clickCount variable
    var clickCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Sets the working layout
        setContentView(R.layout.activity_main)

        //Added a variable to acces the Textview I added to the layout
        val rollCount: TextView = findViewById(R.id.rollCounter)
        val rollButton: Button = findViewById(R.id.roll_button)
        //Listener for the button, reacts on click
        rollButton.setOnClickListener {
            clickCount++
            rollDice()
            //This will add a roll counter on screen
            rollCount.text= clickCount.toString()
        }
        rollCount.text= clickCount.toString()
        diceImage = findViewById(R.id.dice_image)
    }

    private fun rollDice() {
        //Random function to pick a side of the dice to show
        val randomInt = Random().nextInt(6) + 1
        val drawableResource = when (randomInt) {
            1 -> R.drawable.img1
            2 -> R.drawable.img2
            3 -> R.drawable.img3
            4 -> R.drawable.img4
            5 -> R.drawable.img5
            else -> R.drawable.img6
        }
        //Displays the image
        diceImage.setImageResource(drawableResource)
    }
}
