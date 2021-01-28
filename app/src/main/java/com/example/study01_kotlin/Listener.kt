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

        var sum: Int = 0
        var temp: String = "0"
        var result:Int=0

        var btn1: TextView = findViewById(R.id.btn_1)
        var btn2: TextView = findViewById(R.id.btn_2)
        var btn3: TextView = findViewById(R.id.btn_3)
        var btn4: TextView = findViewById(R.id.btn_4)
        var btn5: TextView = findViewById(R.id.btn_5)
        var btn6: TextView = findViewById(R.id.btn_6)
        var btn7: TextView = findViewById(R.id.btn_7)
        var btn8: TextView = findViewById(R.id.btn_8)
        var btn9: TextView = findViewById(R.id.btn_9)
        var btn0: TextView = findViewById(R.id.btn_0)
        var btn_plus: TextView = findViewById(R.id.btn_plus)
        var btn_ca: TextView = findViewById(R.id.btn_ca)
        var tv_result: TextView = findViewById(R.id.tv_result)

        btn1.setOnClickListener {
            temp = temp + "1"
            tv_result.setText(temp)
        }
        btn2.setOnClickListener {
            temp = temp + "2"
            tv_result.setText(temp)
        }
        btn3.setOnClickListener {
            temp = temp + "3"
            tv_result.setText(temp)
        }
        btn4.setOnClickListener {
            temp = temp + "4"
            tv_result.setText(temp)
        }
        btn5.setOnClickListener {
            temp = temp + "5"
            tv_result.setText(temp)
        }
        btn6.setOnClickListener {
            temp = temp + "6"
            tv_result.setText(temp)
        }
        btn7.setOnClickListener {
            temp = temp + "7"
            tv_result.setText(temp)
        }
        btn8.setOnClickListener {
            temp = temp + "8"
            tv_result.setText(temp)
        }
        btn9.setOnClickListener {
            temp = temp + "9"
            tv_result.setText(temp)
        }
        btn0.setOnClickListener {
            temp = temp + "0"
            tv_result.setText(temp)
        }
        btn_plus.setOnClickListener {
            result=temp.toInt()
            temp=""
            sum=sum+result
            tv_result.setText(sum.toString())
        }
        btn_ca.setOnClickListener {
            sum=0
            tv_result.setText("0")
        }


    }
}