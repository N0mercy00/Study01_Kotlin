package com.example.study01_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        Log.d("life_cycle","onCreate")
        var btn_button : Button = findViewById(R.id.btn_button)
        btn_button.setOnClickListener {
            //프라그먼트를 동작으로 작동한느 방법
            var fragementOne : Fragment = FragementOne()
            val fragmentManager : FragmentManager = supportFragmentManager

            //Transaction 작업단위 디비 생각하면 됨 시작,끝존재
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container,fragementOne)
            fragmentTransaction.commit()

            //끝내는 여러방법이 존재재
            //1.commit->가능한 경우에 실행  2.commitnow->지금 당장  둘다 별차이없는데 commit이 안정성 더 높음
        }
   }

    override fun onStart() {
        super.onStart()
        Log.d("life_cycle","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("life_cycle","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("life_cycle","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("life_cycle","onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("life_cycle","onDestroy")
    }
}