package com.example.study01_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.realm.Realm
import io.realm.RealmConfiguration
import kotlinx.android.synthetic.main.activity_realm.*

class RealmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realm)

        //init
        Realm.init(this@RealmActivity)

        //config
        val config : RealmConfiguration = RealmConfiguration.Builder()
            .allowWritesOnUiThread(true)
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.setDefaultConfiguration(config)
        //get
        val realm = Realm.getDefaultInstance()

        btn_realm_save.setOnClickListener {
            //트랜잭션 실행
            realm.executeTransaction{
                //데이터 생성
               with(it.createObject(School::class.java)) {
                   this.name = "무슨 대학교"
                   this.location = "도쿄"
               }
            }
        }
        btn_realm_load.setOnClickListener {
            realm.executeTransaction{
                //작업의 단위는 트랜젝션입니다
                //클래스를 찾아 들어가서 첫번째 아이템을 찾습니다.
                val data = it.where(School::class.java).findFirst()
                Log.d("realm","data : "+data)
            }
        }
        btn_realm_delete.setOnClickListener {
            realm.executeTransaction{
                //작업의 단위는 트랜젝션입니다
                //클래스를 찾아 들어가서 모든 아이템을 찾습니다
                val data = it.where(School::class.java).findAll().deleteAllFromRealm()
            }
        }


    }
}