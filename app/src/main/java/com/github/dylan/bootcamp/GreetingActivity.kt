package com.github.dylan.bootcamp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class GreetingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_greeting)

        val nameField: TextView = findViewById(R.id.greetingMessage)
        val name = intent.getStringExtra("name")
        nameField.text = "Hello ${name.toString()}!"
    }
}