package com.example.study01_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class Resource : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resource)

        //1.
        val ment = resources.getString(R.string.hello)
        Log.d("mentt",ment)
        //2.
        val ment2 = getString(R.string.hello)
        Log.d("mentt",ment2)

        val color =getColor(R.color.testColor)
        Log.d("mentt",color.toString())

    }
}