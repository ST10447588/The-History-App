package com.example.myapplicationages

import  android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.abs


class MainActivity : AppCompatActivity() {
    private lateinit var etAge: EditText
    private lateinit var tvResult: TextView
    private lateinit var tvEnterAge: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val generateHistory = findViewById<Button>(R.id.GenerateHistory)
        val tvEnterAge = findViewById<TextView>(R.id.tvEnterAge).text
        val Clear = findViewById<Button>(R.id.Clear)
        val etAge = findViewById<EditText>(R.id.etAge).text
        val tvResult = findViewById<TextView>(R.id.tvResult)

        // Set a click listener for the "GenerateHistory" button
        generateHistory.setOnClickListener {
            generateHistory()
        }
            // Set a click listener for the "Clear" button
            Clear.setOnClickListener {
                Clear()
            }
        }
        // Function to generate history based on entered age
        private fun generateHistory() {
            val textView = tvEnterAge.toString().trim()
            if (textView.isEmpty()) {
                tvEnterAge.error = "Please enter Age"
                return
            }
            val age = textView.toIntOrNull()
            if (age !in (20..100)) {
                this.etAge.error = "Age must be between 20 and 100"
                return
            }
            val generateHistory = generateHistory()
            tvResult = this.tvEnterAge
        }

        // Function to clear input and result
        private fun Clear() {
            etAge.text.clear()
            tvResult.text = ""
        }

        // Function to get historical figures based on age
        private fun getHistory(age: Int): String {
            val famousPeople = mapOf(
                51 to "Paul Walker",
                48 to "Chadwick Boseman",
                32 to "Mac Miller",
                25 to "Cameron Boyce",
                61 to "Whitney Houston",
                66 to "Michael Jackson",
                53 to "Tupac Shakur",
                98 to "Marilyn Monroe",
                55 to "Matthew Perry",
                155 to "Mahatma Gandhi"
            )
            val closestAge = famousPeople.keys.minByOrNull { abs(n = Int - age) }
            return closestAge?.let {
                "Closest famous person to age $age is ${famousPeople[it]}"
            } ?: "No famous person was found for age $age"
        }
    }
private operator fun Int.Companion.minus(age: Int): Int {
    TODO("Not yet implemented")
}
