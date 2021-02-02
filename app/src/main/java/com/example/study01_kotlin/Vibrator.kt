package com.example.study01_kotlin

import android.content.Context;
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import android.os.VibrationEffect
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_vibrator.*



class Vibrator : AppCompatActivity() {

    var vibrator : Vibrator? = null

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vibrator)


        vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        val vibrationEffect = VibrationEffect.createOneShot(3000,100)

        btn_vibe.setOnClickListener {
            vibrator?.vibrate(vibrationEffect)
        }
    }
}