package com.example.study01_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class Listener : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listener)

        val hello:TextView=findViewById(R.id.hello)
        val image:ImageView=findViewById(R.id.image)

        //세가지 방법
        //람다
        hello.setOnClickListener{
            Log.d("click","Click")
        }

        //익명함수를 사용한 방식
        hello.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                Log.d("click","Click")
            }
        })

        //정석
        var click = object : View.OnClickListener{
            override fun onClick(v: View?) {
                Log.d("click","Click")
                hello.setText("안녕하세요")
                image.setImageResource(R.drawable.youtube)
            }
        }
        hello.setOnClickListener (click)




        //뷰를 조작하는 방법
        //1.setText 2.setImageResource




   }
}