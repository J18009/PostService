package com.example.postservice

import android.os.AsyncTask
import android.util.Log
import java.io.IOException
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import kotlin.properties.Delegates


class AsyncHttp :AsyncTask<String,Int,Boolean>{

    var urlConnection: HttpURLConnection by Delegates.notNull<HttpURLConnection>()
    var flg:Boolean = false

    var name:String=""
    var value:Double=0.0

    constructor(_name:String,_value:Double){
        this.name=_name
        this.value=_value
    }
    //非同期処理
    override fun doInBackground(vararg contents: String?): Boolean {
        val urlinput:String = "http://10.206.0.224/upload/post.php"
        try {
            val url:URL = URL(urlinput)
            urlConnection = url.openConnection() as HttpURLConnection
            urlConnection.requestMethod = "POST"
            urlConnection.doOutput = true

            //POST用パラメータ
            val postDataSample = "name="+name+"&text"+value

            //POSTパラメータ設定
            val out = urlConnection.outputStream
            out.write(postDataSample.toByteArray())
            out.flush()
            out.close()
            Log.d("test", postDataSample)

            //レスポンスを受け取る
            urlConnection.inputStream
            flg = true
        } catch (e: MalformedURLException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return flg
    }

}