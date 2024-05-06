package com.mytamagotchiapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class activity_main2 : AppCompatActivity() {

    //Makes sure the levels don't go below zero
    private var hungerState=5
    private var cleanlinessState=5
    private var happinessState=5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        val image= findViewById<ImageView>(R.id.imageView2)

        val textViewHunger=findViewById<EditText>(R.id.editTextHunger)
        val editTextCleanliness=findViewById<EditText>(R.id.editTextCleanliness)
        val editTextHappiness=findViewById<EditText>(R.id.editTextHappy)

        val buttonFeed=findViewById<Button>(R.id.buttonFeed)
        val buttonClean=findViewById<Button>(R.id.buttonClean)
        val buttonPlay=findViewById<Button>(R.id.buttonPlay)

        //sets the original text values

        textViewHunger.setText(hungerState.toString())
        editTextHappiness.setText(cleanlinessState.toString())
        editTextCleanliness.setText(happinessState.toString())

        //button to feed the animal
        buttonFeed.setOnClickListener{
            hungerState -= 2
            textViewHunger.setText(hungerState.toString())
            image.setImageResource(R.drawable.dog3)
        }

        //button to clean the animal
        buttonClean.setOnClickListener{
            cleanlinessState+=10
            editTextCleanliness.setText(cleanlinessState.toString())
            image.setImageResource(R.drawable.dog4)
        }

        // button to engage with animal
        buttonPlay.setOnClickListener{
            happinessState+=10
            editTextHappiness.setText(happinessState.toString())
            image.setImageResource(R.drawable.dog2)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}