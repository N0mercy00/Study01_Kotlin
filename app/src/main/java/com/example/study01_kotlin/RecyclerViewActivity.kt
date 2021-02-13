package com.example.study01_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recycler_view2.*

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view2)
        var carList =ArrayList<Car>()
        for(i in 0 until 100){
            carList.add(Car("No."+i.toString()+"car","normal"))
        }
        val adapter = RecyclerViewAdapter(carList, LayoutInflater.from(this))
        recycler_view.adapter=adapter
        recycler_view.layoutManager=LinearLayoutManager(this)
    }
}

class RecyclerViewAdapter(
    val itemList : ArrayList<Car>,
    val inflater: LayoutInflater
): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var carName: TextView
        var carEngine : TextView
        init {
            carName=itemView.findViewById(R.id.tv_carname)
            carEngine=itemView.findViewById(R.id.tv_carengine)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //실제로 뷰를 그리는 부분
        val view = inflater.inflate(R.layout.item_view,parent,false)
        return ViewHolder(view)
    }

    //태그달아서 재활용 하는 부분
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //위에서 만든 ViewHolder class에 선언했던 이름과 엔진에 실제로 데이터 넣어주는 부분
        holder.carName.setText(itemList.get(position).name)
        holder.carEngine.setText(itemList.get(position).engine)
    }

    //사이즈 리턴
    override fun getItemCount(): Int {
        return itemList.size
    }

}