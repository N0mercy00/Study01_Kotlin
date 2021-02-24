package com.example.study01_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_register.setOnClickListener {
            val intent = Intent(this, EmailSignupActivity::class.java)
            startActivity(intent)
        }

        btn_login.setOnClickListener {
            val username = et_username_inputbox.text.toString()
            val password = et_password_inputbox.text.toString()

            Toast.makeText(this,"로그인 성공",Toast.LENGTH_LONG).show()
        }
    }
}