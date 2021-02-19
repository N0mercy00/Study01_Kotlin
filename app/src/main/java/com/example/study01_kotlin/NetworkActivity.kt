package com.example.study01_kotlin

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class NetworkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network)

        NetworkTask().execute()

    }
}

class NetworkTask():AsyncTask<Any?,Any?,Any?>(){
    override fun doInBackground(vararg params: Any?): Any? {
        val urlString : String = "http://mellowcode.org/json/students/"
        val url : URL = URL(urlString)
        val connection : HttpURLConnection =url.openConnection() as HttpURLConnection

        connection.requestMethod="GET"
        connection.setRequestProperty("Content-Type","application/json")

        var buffer=""
        if(connection.responseCode==HttpURLConnection.HTTP_OK){
            val reader = BufferedReader(
                InputStreamReader(
                    connection.inputStream
                    //charsetName:"UTF-8"
                )
            )
            buffer = reader.readLine()
        }
        return null
    }
}