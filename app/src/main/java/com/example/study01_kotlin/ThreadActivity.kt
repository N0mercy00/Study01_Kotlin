package com.example.study01_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class ThreadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)

        var btn_thread: Button =findViewById(R.id.btn_thread)

        //러너블 만들기
        var runnable : Runnable = object :Runnable{
            override fun run() {
                Log.d("thread1","is made")
            }

        }
        //스레드 만들기, 그리고 러너블을 넣어주기
        var thread : Thread = Thread(runnable)
        btn_thread.setOnClickListener {
            //스레드 시작
            thread.start()
        }

        //더욱 단축해서 스레드 만들기
        Thread(object :Runnable{
            override fun run() {
                Log.d("thread1","is made 2")
            }
        }).start()

        //람다를 사용하여 더욱 단축하기
        Thread(Runnable {
            Log.d("thread1","is made 3")
        }).start()


    }
}