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

        val view : View
        val holder : ViewHoler

        //convertView 가 재활용 될 View 없는 경우 만들어주기 (처음엔 하나 만들어줘야지)
        if(convertView==null){
            view=layoutInflater.inflate(R.layout.item_view,null)
            holder= ViewHoler()

            //찾은다음 홀더에 집어 넣는다.
            holder.carName = view.findViewById(R.id.tv_carname)
            holder.carEngine= view.findViewById(R.id.tv_carengine)

            //찾을수 있게 태그를 달아둔다다
            view.tag=holder
        }else{
            //재활용할 View가 있는 경우  넣어주기 솔직히 이부분 이해안됨
                //태그는 뭐고 대충 걍 재활용한다는 것만 알겠음
            holder=convertView.tag as ViewHoler
            view =convertView
        }

        //재활용은 재활용이고 데이터도 넣어줘야함
        holder.carName?.setText(Car.get(position).name)
        holder.carEngine?.setText(Car.get(position).engine)
        return view

    }

}

class ViewHoler{
    var  carName : TextView?=null
    var carEngine : TextView? =null
}