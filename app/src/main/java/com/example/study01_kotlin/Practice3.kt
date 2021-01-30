package com.example.study01_kotlin

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class Practice3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice3)

        var btn_openUri : Button = findViewById(R.id.btn_openURI)
        var tv_input : EditText =findViewById(R.id.tv_input)
        var URI : String

        btn_openUri.setOnClickListener {
                URI=tv_input.getText().toString()
                Log.d("uri",URI)

            var intent3 = Intent(Intent.ACTION_VIEW, Uri.parse(URI))
            startActivity(intent3)


        }

    }
}