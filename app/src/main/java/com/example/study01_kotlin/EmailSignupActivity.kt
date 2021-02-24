package com.example.study01_kotlin

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class EmailSignupActivity : AppCompatActivity() {
    //

    lateinit var usernameView : EditText
    lateinit var userPasswordView1 : EditText
    lateinit var userPasswordView2 : EditText
    lateinit var registerBtn:TextView
    lateinit var loginBtn:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email_signup)

        initView(this@EmailSignupActivity)
        setupListener(this)
    }

    //아이디와 비밀번호를 ㅁ가져올 수 있는 함수를 먼저 만들자

    //뷰 아이디 찾아서 일단 초기화
    fun initView (activity:Activity){
        usernameView=activity.findViewById(R.id.et_username_inputbox)
        userPasswordView1=activity.findViewById(R.id.et_password1_inputbox)
        userPasswordView2=activity.findViewById(R.id.et_password2_inputbox)
        registerBtn=activity.findViewById(R.id.btn_register)
        loginBtn=activity.findViewById(R.id.btn_login)
    }

    fun setupListener(activity: Activity){
        registerBtn.setOnClickListener {
            register(this)
        }
        loginBtn.setOnClickListener {
           startActivity(
               Intent(this,LoginActivity::class.java)
           )

        }

    }

    //가입함수
    fun register(activity: Activity){
        val username = getUserName()
        val password1 = getUserPassword1()
        val password2 = getUserPassword1()


        (application as MasterApplication).service.register(
            username, password1, password2
        ).enqueue(object:
            Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if(response.isSuccessful){
                    Toast.makeText(activity,"가입 성공",Toast.LENGTH_LONG).show()
                    val user = response.body()
                    val token = user!!.token!!
                    saveUserToken(token,activity)
                    (application as MasterApplication).createRetrofit()
                }
            }
            override fun onFailure(call: Call<User>, t: Throwable) {
                Toast.makeText(activity,"가입 실패",Toast.LENGTH_LONG).show()
            }
        })
    }

    //토큰저장
    fun saveUserToken(token:String, activity: Activity){
        val sp = activity.getSharedPreferences("login_sp",Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.putString("login_sp",token)
        editor.commit()
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