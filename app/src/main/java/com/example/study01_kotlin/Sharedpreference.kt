package com.example.study01_kotlin

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlinx.android.synthetic.main.activity_sharedpreference.*

class Sharedpreference : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sharedpreference)

        //SharedPreference 선언 및 저장하는 방법
        val sharedpreference = getSharedPreferences("sp1", MODE_PRIVATE)
        //에디터 만들어주기 (에디터로 관리)
        val editor : SharedPreferences.Editor = sharedpreference.edit()
        //데이터 넣어주기
        editor.putString("hello","안녕하세요")
        //커밋까지 해야지 적용됨
        editor.commit()

        val btn_sp1 :Button = findViewById<Button>(R.id.btn_sp1)
        btn_sp1.setOnClickListener {
            //값을 불러오는 방법
            val sharedPreferences = getSharedPreferences("sp1", MODE_PRIVATE)
            val value = sharedPreferences.getString("hello","데이터없음")
            Log.d("sp","Value : "+value)
        }
    }
}