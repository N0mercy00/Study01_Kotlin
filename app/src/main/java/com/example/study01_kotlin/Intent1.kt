package com.example.study01_kotlin

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class Intent1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent1)

        var btn_intent1 :TextView = findViewById(R.id.btn_intent1)

        btn_intent1.setOnClickListener {
            //1.인텐트를 이용한 첫번째 방법
//            var intent = Intent(this@Intent1,Intent2::class.java)
//            //putExtra를 이용하여 정보를 전송할 수 있다
//            //putExtra(<이름>,<데이터>)key value 방식으로 전송
//            intent.putExtra("number1",1)
//            intent.putExtra("number2",2)
//            startActivity(intent)

            //2.다른 방법 <권장방법>
//            var intent2 = Intent(this@Intent1,Intent2::class.java)
//            //apply 코틀린에서 유용한 기능 대충 apply앞에 붙은애들을 this로 바꾸서 사용 할 수 있게 해줌
//            //가독성이 좋아지니깐 쓰는것 권장
//            intent2.apply {
//                this.putExtra("number1",1)
//                this.putExtra("number2",2)
//            }
//            //요청에 대한 결과값을 받기위해서는 아래 함수를 사용해야함
//            startActivityForResult(intent2,200)

            //3.암시적으로 사용하는 방법(가능한 대상에게 요청하는거)
            //링크열기 누르면 막 여러개 브라우저 뜨는거 있잖아? 선택하라고, 그거임
            var intent= Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"))
            startActivity(intent)
        }
    }

    //인텐트2로부터 결과를 받는 함수
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        //내가 보낸 결과가 맞는지 알기위해 요청 코드조건문
        if(requestCode==200){
            var result = data?.getIntExtra("result",0)
            Log.d("number",result.toString())
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}