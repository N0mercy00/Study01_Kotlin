package com.example.study01_kotlin

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_permmision.*

class PermmisionA : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permmision)


        btn_permmisionAsk.setOnClickListener {


            //권한이 있는지 체크하기
            val cameraPermissionCheck = ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.CAMERA
            )
            if (cameraPermissionCheck != PackageManager.PERMISSION_GRANTED) {
                //권한이 없는 경우

                ActivityCompat.requestPermissions(
                    this,
                    //하나만 보내도 배열로보냄
                    arrayOf(android.Manifest.permission.CAMERA),
                    1000
                )
            } else {
                //권한 있는경우
                Log.d("perA", "권한 존재함함")
            }
        }
    }

    //사용자에게 요청을 보내고 나서 실행
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1000) {
            //권한 요청에 대한 답변이 온경우

            //배열로 결과가 오기때문에 꺼내줌 (우린 카메라 하나만 보냈으니 인덱스0꺼내줌)
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //요청을 승락한경우
                Log.d("perA", "요청 승락")
            } else {
                //요청을 거부한경우
                Log.d("perA", "요청 거부됨")
            }

        }
    }
}