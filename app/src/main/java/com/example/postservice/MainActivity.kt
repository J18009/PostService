

package com.example.postservice


import android.os.Bundle

import android.view.View

import android.widget.Button

import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    var b1: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        b1 = findViewById<View>(R.id.button1) as Button

        b1!!.setOnClickListener {

            val post = AsyncHttp("Android", 10.11)

            post.execute()

        }

    }

}

