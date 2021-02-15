package com.example.study01_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_tab_pager.*

class TabPagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_pager)

        tab_layout.addTab(tab_layout.newTab().setText("ONE"))
        tab_layout.addTab(tab_layout.newTab().setText("TWO"))
        tab_layout.addTab(tab_layout.newTab().setText("THREE"))

        val pagerAdapter =FragmentPageAdapter(supportFragmentManager,3)
        view_pager.adapter=pagerAdapter

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
        //pager가 이동시 탭을 이동시키는 역할
        view_pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))


    }
}

class FragmentPageAdapter(
    fragmentManager: FragmentManager,
    val tabCount:Int
):FragmentPagerAdapter(fragmentManager){
    override fun getCount(): Int {
        return tabCount
    }

    override fun getItem(position: Int): Fragment {
        when(position){
            0->{
                return Fragment1()
            }
            1->{
                return Fragment2()
            }
            2->{
                return Fragment3()
            }else -> {
                return Fragment1()
            }
        }
    }
}