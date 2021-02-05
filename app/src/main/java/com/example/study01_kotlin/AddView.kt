package com.example.study01_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView

class AddView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_view)

        //아이템 리스트 준비
        var carList =ArrayList<Car>()
        for(i in 0 until 100){
            carList.add(Car("No."+i.toString()+"car","normal"))
        }

        //애드뷰로 더하기기 구조는 컨테이너>뷰>내용물
        val container : LinearLayout = findViewById(R.id.lv_addview)//뷰단위 최상단 컨테이너
        val inflater = LayoutInflater.from(this@AddView) //뭔지모르겠지만 일단 따라침
        for(i in 0 until carList.size){//반복하면서 추가해주는 부분
            val itemView = inflater.inflate(R.layout.item_view,null)//컨테이너 안에 들어갈 뷰
            val carNameView = itemView.findViewById<TextView>(R.id.tv_carname)//뷰안에 텍스트뷰
            val carEngineView : TextView = itemView.findViewById(R.id.tv_carengine)

            carNameView.setText(carList.get(i).name)//텍스트뷰에 내용물 넣어줌
            carEngineView.setText(carList.get(i).engine)
            container.addView(itemView)
        }
    }
}

class Car(val name:String, val engine:String) {

}