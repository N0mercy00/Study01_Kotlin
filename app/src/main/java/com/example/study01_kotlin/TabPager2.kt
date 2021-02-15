package com.example.study01_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_tab_pager.*

class TabPager2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_pager)

        tab_layout.addTab(tab_layout.newTab().setText("ONE"))
        tab_layout.addTab(tab_layout.newTab().setText("TWO"))
        tab_layout.addTab(tab_layout.newTab().setText("THREE"))

        val adapter = ThreePageAdapter(LayoutInflater.from(this@TabPager2))
        view_pager.adapter=adapter
        view_pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))

        //탭이 선택되었을때 역할을 하는 리스너
        tab_layout.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                //탭을 클릭한경우 현재 아이템을 클릭된 탭의 페이지로 이동시킴
                view_pager.currentItem=tab!!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })
    }

}

class ThreePageAdapter(
    val layoutInflater: LayoutInflater
):PagerAdapter(){
    override fun getCount(): Int {
        return 3
    }

    //잘불려왔는지 확인하는거 같음
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        //===는 주소까지 `완전히` 동일한지 비교
        return view === `object` as View
    }

    //뷰가 필요없어졌을경우 파괴괴
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        //객체를 뷰로 캐스팅해서 (지금현재는 any타입) 제거해준다
        container.removeView(`object` as View)
    }

    //뷰를 그리는 부분
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        when(position){
            0->{
                val view = layoutInflater.inflate(R.layout.fragement_one,container,false)
                container.addView(view)
                return view
            }
            1->{
                val view = layoutInflater.inflate(R.layout.fragment_two,container,false)
                container.addView(view)
                return view
            }
            2->{
                val view = layoutInflater.inflate(R.layout.fragment_three,container,false)
                container.addView(view)
                return view
            }
            else->{
                val view = layoutInflater.inflate(R.layout.fragement_one,container,false)
                container.addView(view)
                return view
            }

        }
    }
}