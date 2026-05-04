package com.example.lifehackapp

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ReviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_review)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }




        val layout = findViewById<LinearLayout>(R.id.reviewLayout)



        val questions = arrayOf(

            "Cracking your knuckles cause arthrits",

            "Chewing gum stays in your stomach for seven years" +

            "Drinking warm milk helps you fall asleep fast",

            "Reading in low light permantly damages your eyes " +

            "using the '2-minutes rule' stops procrastinaton"

        )



        val answers = arrayOf(false, true, false, true, false)



        for (i in questions.indices) {

            val tv = TextView(this)

            val answerText = if (answers[i]) "Hack" else "Myth"

            tv.text = "${questions[i]}\nAnswer: $answerText\n"

            tv.setPadding(0, 0, 0, 20)

            layout.addView(tv)

        }

    }

}