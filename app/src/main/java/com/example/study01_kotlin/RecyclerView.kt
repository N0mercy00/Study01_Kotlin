package com.example.study01_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatViewInflater
import org.w3c.dom.Text

class RecyclerView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        var carList =ArrayList<Car>()
        for(i in 0 until 100){
            carList.add(Car("No."+i.toString()+"car","normal"))
        }
    }
}

class Adapter(
    val itemList : ArrayList<Car>,
    val inflater: LayoutInflater
): RecyclerView.Adapter<Adapter.ViewHolder>(){

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        var carName:TextView
        var carEngine : TextView
        init {
            carName=itemView.findViewById(R.id.tv_carname)
            carEngine=itemView.findViewById(R.id.tv_carengine)
        }
    }

}