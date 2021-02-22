package com.example.study01_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ContextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_context)

        //1.
        val context : ContextActivity =this
        //2.
        val applicationContext = getApplicationContext()

    }
}