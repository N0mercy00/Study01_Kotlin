package com.example.study01_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_call_book_detail.*

class CallBookDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_call_book_detail)
        getPersonInfoAndDraw()
        iv_back.setOnClickListener {
            onBackPressed()
        }
    }

    fun getPersonInfoAndDraw(){
        val name = intent.getStringExtra("name")
        val number = intent.getStringExtra("number")

        tv_person_detailname.setText(name)
        tv_person_detailnumber.setText(number)

    }
}