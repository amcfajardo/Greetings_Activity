package com.airafajardo.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        val nextBtn = findViewById<Button>(R.id.btnDedicationPage)

        nextBtn.setOnClickListener {
            val intent = Intent(this, Dedication::class.java)
            startActivity(intent)
        }
        val starIds = listOf(
            R.id.stars, R.id.stars2, R.id.stars3, R.id.stars4,
            R.id.stars5, R.id.stars6, R.id.stars7, R.id.stars8, R.id.stars9
        )

        starIds.forEach { id ->
            val star = findViewById<TextView>(id)
            val anim = AnimationUtils.loadAnimation(this, R.anim.star_firstpage).apply {

                duration = 700L + Random.nextLong(0, 300)
            }
            star.startAnimation(anim)
        }


    }
}

