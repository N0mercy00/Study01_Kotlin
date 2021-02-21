package com.example.study01_kotlin

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class EmailSignupActivity : AppCompatActivity() {
    //

    lateinit var usernameView : EditText
    lateinit var userPasswordView1 : EditText
    lateinit var userPasswordView2 : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email_signup)

        initView(this@EmailSignupActivity)
    }

    //아이디와 비밀번호를 ㅁ가져올 수 있는 함수를 먼저 만들자

    //뷰 아이디 찾아서 일단 초기화
    fun initView (activity:Activity){
        usernameView=activity.findViewById(R.id.et_username_inputbox)
        userPasswordView1=activity.findViewById(R.id.et_password1_inputbox)
        userPasswordView2=activity.findViewById(R.id.et_password2_inputbox)
    }

    //아이디랑 비밀번호 가져오기기
   fun getUserName():String{
        return usernameView.text.toString()
    }
    fun getUserPassword1():String{
        return userPasswordView1.text.toString()
    }
    fun getUserPassword2():String{
        return userPasswordView2.text.toString()
    }
}