package com.example.study01_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_library.*

class Library : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)

        Glide.with(this)
            .load("https://upload.wikimedia.org/wikipedia/commons/d/d3/Supreme_pizza.jpg")
            .fitCenter()
            .centerCrop()
            .into(img_glide)

    }
}