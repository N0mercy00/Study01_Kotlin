package com.example.study01_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Intent1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent1)
        var btn_intent1 :TextView = findViewById(R.id.btn_intent1)
        btn_intent1.setOnClickListener {
            var intent = Intent(this@Intent1,Intent2::class.java)
            startActivity(intent)
        }
    }
}