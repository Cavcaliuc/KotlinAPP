package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PageUser_Logged_Activity : AppCompatActivity() {
    private var socket: ConfirmationWebSocket? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_user__logged_)

        socket = ConfirmationWebSocket(this)


    }
}
