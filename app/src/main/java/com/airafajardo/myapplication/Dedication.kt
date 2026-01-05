package com.airafajardo.myapplication

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Dedication : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dedication)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val fast = AnimationUtils.loadAnimation(this, R.anim.snowfall_fast)
        val slow = AnimationUtils.loadAnimation(this, R.anim.snowfall_slow)
        val mid = AnimationUtils.loadAnimation(this, R.anim.snowfall_mid)
        fun Animation.randomizeStartOffset(maxOffset: Long = 2000) {
            this.startOffset = (0..maxOffset).random()
        }


        val snowflakes = listOf(
            findViewById<TextView>(R.id.snow1),
            findViewById<TextView>(R.id.snow2),
            findViewById<TextView>(R.id.snow3),
            findViewById<TextView>(R.id.snow5),
            findViewById<TextView>(R.id.snow6),
            findViewById<TextView>(R.id.snow7),
            findViewById<TextView>(R.id.snow8),
            findViewById<TextView>(R.id.snow9),
            findViewById<TextView>(R.id.snow10),
            findViewById<TextView>(R.id.snow11),
            findViewById<TextView>(R.id.snow12),
            findViewById<TextView>(R.id.snow13),
            findViewById<TextView>(R.id.snow14),
            findViewById<TextView>(R.id.snow15),
            findViewById<TextView>(R.id.snow16),
            findViewById<TextView>(R.id.snow17),
            findViewById<TextView>(R.id.snow18),
            findViewById<TextView>(R.id.snow19),
            findViewById<TextView>(R.id.snow20),
            findViewById<TextView>(R.id.snow21),
            findViewById<TextView>(R.id.snow22),
            findViewById<TextView>(R.id.snow23),
            findViewById<TextView>(R.id.snow24),
            findViewById<TextView>(R.id.snow25),
            findViewById<TextView>(R.id.snow26),
            findViewById<TextView>(R.id.snow27),
            findViewById<TextView>(R.id.snow28),
            findViewById<TextView>(R.id.snow29)
        )


        snowflakes.forEach { snow ->
            val anim = when ((1..3).random()) {
                1 -> fast
                2 -> mid
                else -> slow
            }
            anim.randomizeStartOffset(3000)
            snow.startAnimation(anim)
        }

    }
}