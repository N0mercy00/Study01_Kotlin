package com.example.study01_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView

class Callbook : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_callbook)

        val phonebook = createFakePhoneBook()
        createBookList(phonebook)
    }

    fun createFakePhoneBook(fakeNumber:Int=10,Book:Book=Book()):Book{
        for(i in 0 until fakeNumber){
            Book.addPerson(
                Person(name=""+i+"번째 사람", number = ""+i+"번째 사람의 전화번호")
            )
        }
        return Book
    }
    fun createBookList(Book:Book){
        val layoutInflater = LayoutInflater.from(this@Callbook)
        val container = findViewById<LinearLayout>(R.id.lv_book_list_container)
        for(i in 0 until Book.personList.size){
            val view =layoutInflater.inflate(R.layout.callbook_item_view,null)
            val personNameView = view.findViewById<TextView>(R.id.tv_personname)
            personNameView.setText(Book.personList.get(i).name)
            container.addView(view)
        }
    }
}

class Book(){
    //전화번호부
    var personList =ArrayList<Person>()
    fun addPerson(Person:Person){
        personList.add(Person)
    }
}

class Person(var name : String , val number : String){
    //전화번호부 내부 사람
}