package com.example.study01_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class NullSafety : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_null_safety)

        var number1 : Int = 10
        var number2:Int?=null
        var number3 = number2?.plus(number1)
        Log.d("number","number : "+number3)

        fun plus(a:Int, b:Int?):Int{
            if(b!=null){
                return a+b
            }else{
                return a
            }
        }
        fun plus2(a:Int,b:Int):Int?{
            return b?.plus(a)
        }

        //엘비스 연산 (삼항연산자)

        var number4 :Int = number1?:20 //number1=10
        Log.d("number",number4.toString())
        number4 = number2?:30 //number2 = null
        Log.d("number",number4.toString())

    }
}