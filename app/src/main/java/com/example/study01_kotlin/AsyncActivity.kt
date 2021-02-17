package com.example.study01_kotlin

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_async.*

class AsyncActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async)

        var task:BackgroundAsyncTask?=null
        btn_async_start.setOnClickListener {
            task = BackgroundAsyncTask(pb_progressbar,tv_astnc_ment)
            task?.execute()
        }
        btn_async_cancle.setOnClickListener {
            task?.cancel(true)
        }
    }
}

class BackgroundAsyncTask(
    val progressBar: ProgressBar,
    val progressText : TextView
): AsyncTask<Int,Int,Int>(){
    //params ->doInBackground에서 사용할 타입
    //progress -> onProgressUpdate에서 사용할 타입
    //result -> onPostExecute에 사용할 타입
    var percent:Int = 0 //퍼센트 초기값

    override fun onPreExecute() {
        //실행 시작 전 퍼센트 0으로 초기화 하고 셋팅하기
        percent = 0
        progressBar.setProgress(percent)
    }

    override fun doInBackground(vararg params: Int?): Int {
        //취소 되지 않았으면 돌린다
        while(isCancelled()==false){
            percent++;
            if(percent>100){
                break
            }else{
                //100퍼 안됬으면 현재 퍼센트 보냄  보낸건 onProgressUpdate에서 받음
                publishProgress(percent)
            }
            try{
                //컴퓨터는 너무 빨리차서 천천히
                Thread.sleep(10)
            }catch (e:Exception){
                e.printStackTrace()
            }
        }
        return percent
    }

    //여기서는 doInBackground에서 업데이트 되는 것들을 받아와서 프로그레스 바와 텍스트에 적용합니다.
    override fun onProgressUpdate(vararg values: Int?) {
        //values는 두인백그라운드에서 사용되는 percent입니다.
        progressBar.setProgress(values[0]?:0)
        progressText.setText("실행중 : "+ values[0]+" %")
        super.onProgressUpdate(*values)
    }

    //작업이 끝난후
    override fun onPostExecute(result: Int?) {
        progressText.setText("완료.")
    }

    //작업이 중간에 취소된경우
    override fun onCancelled(result: Int?) {
        progressBar.setProgress(0)
        progressText.setText("작업이 취소됨.")
    }
}