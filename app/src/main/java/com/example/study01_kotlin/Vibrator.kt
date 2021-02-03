package com.example.study01_kotlin

import android.content.Context;
import android.media.Ringtone
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import android.os.VibrationEffect
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_vibrator.*



class Vibrator : AppCompatActivity() {

    var vibrator : Vibrator? = null
    var ringtone:Ringtone?=null

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vibrator)

        //기본알람
        //val uriRingtone = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)
        var uriRingtone = Uri.parse("android.resource://"+"com.example.study01_kotlin"+"/"+R.raw.danger)
        ringtone = RingtoneManager.getRingtone(this,uriRingtone)

        vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        val vibrationEffect = VibrationEffect.createOneShot(3000,100)

        btn_vibe.setOnClickListener {
            vibrator?.vibrate(vibrationEffect)
        }

        btn_ring.setOnClickListener {
            ringtone?.run{
                if(!isPlaying)play()
                else stop()
            }
        }


    }

    override fun onPause() {
        vibrator?.cancel()
        ringtone?.stop()
        super.onPause()
    }
}