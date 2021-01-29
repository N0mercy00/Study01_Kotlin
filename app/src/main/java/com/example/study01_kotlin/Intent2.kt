package com.example.study01_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button

class Intent2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent2)


        var btn_intent_result: Button = findViewById(R.id.btn_intent_result)
        btn_intent_result.setOnClickListener {
            //Intent1에서 전달된 두 데이터 받음
            var number1: Int = intent.getIntExtra("number1", 0)
            var number2: Int = intent.getIntExtra("number2", 0)
            Log.d("number", number1.toString())
            Log.d("number", number2.toString())

            //받은 데이터 더해줌
            var result = number1 + number2
            //결과값 되돌려줄 인텐트 생성&값 넣기기
            var resultIntent = Intent()
            resultIntent.putExtra("result", result)
            //결과로 반환(전송해주는것) setResult = 요청이 마무리됨 알려줌
            setResult(RESULT_OK, resultIntent)
            finish()//->액티비티를 종료하는 함수 인텐트는 스택개념으로 생성됨
            // 인텐트2를 없애면 먼저 생성된 인텐트1이 화면으로 나타남 즉 인텐트1->인텐트2 로 온것처럼
            //인텐트2->인텐트1로 이동하는게 아니라 만들어진 인텐트2를 지우면
            // 원래있던 인텐트1로 이동되는것처럼 보임임
        }


    }
}