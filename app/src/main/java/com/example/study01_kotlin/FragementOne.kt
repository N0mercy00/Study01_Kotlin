package com.example.study01_kotlin

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class FragementOne : Fragment(){
    override fun onAttach(context: Context) {
        Log.d("life_cycle","FonAttach")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("life_cycle","FonCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("life_cycle","FonCreateView")

        //프라그먼트가 인터페이스를 처음으로 그릴때 호출된다
        //inflater -> 뷰를 그려주는 역할
        //container -> 부모뷰
        return inflater.inflate(R.layout.fragement_one,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("life_cycle","FonViewCreated")
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d("life_cycle","FonActivityCreated")
        val data = arguments?.getString("hello")
        Log.d("data",data.toString())
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        Log.d("life_cycle","FonStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d("life_cycle","FonResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d("life_cycle","FonPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d("life_cycle","FonStop")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.d("life_cycle","FonDestroyView")
        super.onDestroyView()
    }

    override fun onDetach() {
        Log.d("life_cycle","FonDetach")
        super.onDetach()
    }
}