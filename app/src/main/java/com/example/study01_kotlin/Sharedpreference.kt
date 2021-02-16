package com.example.study01_kotlin

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




        btn_sp1_save.setOnClickListener {
            //SharedPreference 선언 및 저장하는 방법
            val sharedpreference = getSharedPreferences("sp1", MODE_PRIVATE)
            //에디터 만들어주기 (에디터로 관리)
            val editor : SharedPreferences.Editor = sharedpreference.edit()
            //데이터 넣어주기
            editor.putString("hello","안녕하세요")
            editor.putString("bye","안녕가세요")
            //커밋까지 해야지 적용됨
            editor.commit()
        }


        btn_sp1_load.setOnClickListener {
            //값을 불러오는 방법
            val sharedPreferences = getSharedPreferences("sp1", MODE_PRIVATE)
            val value1 = sharedPreferences.getString("hello","데이터없음")
            val value2 = sharedPreferences.getString("bye","데이터없음")
            Log.d("sp","\n"+"Value1 : "+value1 +"\t"+"Value2 : "+value2)
        }

        btn_sp1_delete.setOnClickListener {
            val sharedPreferences = getSharedPreferences("sp1", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            //key값으로 지우기
            //editor.remove("hello")
            //전체 다지우기
            editor.clear()
            editor.commit()
        }
    }
}