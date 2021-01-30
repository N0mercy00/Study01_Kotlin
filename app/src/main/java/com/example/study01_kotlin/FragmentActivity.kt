package com.example.study01_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
//프라그먼트를 동작으로 작동한느 방법
class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        Log.d("life_cycle","onCreate")




        var btn_button : Button = findViewById(R.id.btn_button)
        var btn_button2 : Button = findViewById(R.id.btn_button2)
        var fragementOne : Fragment = FragementOne()

        //프라그먼트에 데이터를 넣어주는 방법
        //번들을 만들어서 끼워줘야함
        val bundle:Bundle = Bundle()
        bundle.putString("hello","hello")
        fragementOne.arguments=bundle


        btn_button.setOnClickListener {
            //프라그먼트 추가해주는 방법 add/replace
            //프라그먼트 매니저가 있어야 작동함
            val fragmentManager : FragmentManager = supportFragmentManager
            //Transaction 작업단위 디비 생각하면 됨 시작,끝존재
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container,fragementOne)
            fragmentTransaction.commit()

            //끝내는 여러방법이 존재재
            //1.commit->가능한 경우에 실행  2.commitnow->지금 당장  둘다 별차이없는데 commit이 안정성 더 높음
        }

        btn_button2.setOnClickListener {
            //프라그먼트 제거하는 방법 remove/detach rm은 다시 붙기 가능하고 det은 다시 못붙힘
            val fragmentManager:FragmentManager=supportFragmentManager
            val fragmentTransaction =fragmentManager.beginTransaction()
            fragmentTransaction.remove(fragementOne)
            fragmentTransaction.commit()
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