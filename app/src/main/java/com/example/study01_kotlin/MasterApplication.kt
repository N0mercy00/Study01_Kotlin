package com.example.study01_kotlin

import android.app.Application
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MasterApplication:Application() {

    lateinit var service : RetrofitService
    override fun onCreate() {
        super.onCreate()
    }

    //나가는 통신 잡아서 헤더 붙혀줌
    fun createRetrofit() {
        val header = Interceptor {
            val original = it.request()
            val request = original.newBuilder()
                .header("Authorization", "")
                .build()
            it.proceed(request)
        }

        val client = OkHttpClient.Builder()
            .addInterceptor(header)
            .addNetworkInterceptor(StethoInterceptor())
            .build()

        //retrofit 만들어줌줌
        val retrofit = Retrofit.Builder()
            .baseUrl("http://mellowcode.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        service= retrofit.create(RetrofitService::class.java)
    }

    fun checkIsLogin():Boolean{
        //여기서 로그인 되었는지 확인
        //아직 구현 안한거임
        return true
    }

}
