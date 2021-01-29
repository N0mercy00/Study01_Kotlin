package com.example.study01_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Intent1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent1)

        var btn_intent1 :TextView = findViewById(R.id.btn_intent1)

        btn_intent1.setOnClickListener {
//            var intent = Intent(this@Intent1,Intent2::class.java)
//            //putExtra를 이용하여 정보를 전송할 수 있다
//            //putExtra(<이름>,<데이터>)key value 방식으로 전송
//            intent.putExtra("number1",1)
//            intent.putExtra("number2",2)
//            startActivity(intent)

            //다른 방법
            var intent2 = Intent(this@Intent1,Intent2::class.java)
            //apply 코틀린에서 유용한 기능 대충 apply앞에 붙은애들을 this로 바꾸서 사용 할 수 있게 해줌
            //가독성이 좋아지니깐 쓰는것 권장
            intent2.apply {
                this.putExtra("number1",1)
                this.putExtra("number2",2)
            }
            startActivity(intent2)
        }
    }
}