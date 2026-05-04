package com.example.lifehackapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class QuizActivity : AppCompatActivity() {

    private var index = 0
    private var score = 0

    private lateinit var questionText: TextView
    private lateinit var feedbackText: TextView

    private val questions = arrayOf(
        "Can a car move with out petrol?",
        "Can a human being survive withot water?",
        "drinking coffe is not healty",
        "Drinking warm milk helps you fall asleep fast",
        "Charging a phone overnight is not a good idea",
        "Does coding need you to be smart",
        "can a human being suvive without a heart"
    )

    private val answers = arrayOf(false, true, false, true, false, false, false)

    private val explanations = arrayOf(
        "Myth: cars cant move without petrol.",
        "Hack: A human can survive without water.",
        "Myth: Coffe is not healty.",
        "Hack: Drinking warm milk helps you fall asleep fast.",
        "Myth: Charging a phone overnight is not a good idea.",
        "Hack: Coding doesnt need you to be smart",
        "Myth: A human can survive without a heart"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        val mainView = findViewById<android.view.View>(R.id.main)
        ViewCompat.setOnApplyWindowInsetsListener(mainView) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        questionText = findViewById(R.id.questionText)
        feedbackText = findViewById(R.id.feedbackText)

        val hackButton = findViewById<Button>(R.id.hackButton)
        val mythButton = findViewById<Button>(R.id.mythButton)
        val nextButton = findViewById<Button>(R.id.nextButton)

        loadQuestion()

        hackButton.setOnClickListener { checkAnswer(true) }
        mythButton.setOnClickListener { checkAnswer(false) }

        nextButton.setOnClickListener {
            index++

            if (index < questions.size) {
                loadQuestion()
                feedbackText.text = ""
            } else {
                val intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("score", score)
                intent.putExtra("total", questions.size)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun loadQuestion() {
        questionText.text = questions[index]
    }

    private fun checkAnswer(userAnswer: Boolean) {
        if (userAnswer == answers[index]) {
            feedbackText.text = getString(R.string.correct_feedback, explanations[index])
            score++
        } else {
            feedbackText.text = getString(R.string.wrong_feedback, explanations[index])
        }
    }
}
