package com.github.dylan.bootcamp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.mainGoButton)
        val nameField: EditText = findViewById(R.id.mainName)

        button.setOnClickListener {
            val intent = Intent(this, GreetingActivity::class.java)
            intent.putExtra("name", nameField.text.toString())
            startActivity(intent)
        }
    }
}