package com.example.study01_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_list_view.*

class ListView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        var carList =ArrayList<Car>()
        for(i in 0 until 100){
            carList.add(Car("No."+i.toString()+"car","normal"))
        }

        val adapter = ListViewAdapter(carList, LayoutInflater.from(this))
        lv_listview.adapter=adapter
        //아이템 클릭 리스너
        lv_listview.setOnItemClickListener { parent, view, position, id ->
            //아이템의 정보를 받아오기 as Car부분은 잘 이해안되니 나중에 다시보기
            val carname = (adapter.getItem(position)as Car).name
            val carengine = (adapter.getItem(position)as Car).engine

            Toast.makeText(this,carname+" "+carengine,Toast.LENGTH_SHORT).show()

        }
    }
}

class ListViewAdapter(
    val Car : ArrayList<Car>,
    val layoutInflater: LayoutInflater
):BaseAdapter(){
    //전체 사이즈 알려주는 부분
    override fun getCount(): Int {
       return Car.size
    }
    //하나의 아이템을 가져오는 부분(그리고자 하는 아이템 리스트의 하나 의 포지션)
    override fun getItem(position: Int): Any {
        return Car.get(position)
    }
    //각아이템에 아이디를 부여하는 부분(해당 포지션에 아이디 설정)
    override fun getItemId(position: Int): Long {
       return position.toLong()
    }
    //실제로 가져오는 부분
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = layoutInflater.inflate(R.layout.item_view,null)
        var carNameTextView = view.findViewById<TextView>(R.id.tv_carname)
        var carEngineTextView = view.findViewById<TextView>(R.id.tv_carengine)

        carNameTextView.setText(Car.get(position).name)
        carEngineTextView.setText(Car.get(position).engine)
        return view

    }

}