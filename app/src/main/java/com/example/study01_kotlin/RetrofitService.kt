package com.example.study01_kotlin

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*


interface RetrofitService {

    @POST("user/signup/")
    @FormUrlEncoded
    fun register(
       @Field("username")username : String,
       @Field("password1")password1 : String,
       @Field("password2")password2 : String
    ):Call<User>

    @POST("user/login/")
    @FormUrlEncoded
    fun login(
        @Field("username")username : String,
        @Field("password")password : String
    ):Call<User>



}