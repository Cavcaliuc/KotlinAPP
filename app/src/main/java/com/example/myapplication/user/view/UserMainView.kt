package com.example.myapplication.user.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myapplication.ConfirmationWebSocket
import com.example.myapplication.R
import com.example.myapplication.ReservationActivity


class UserMainView : AppCompatActivity() {
    private var socket: ConfirmationWebSocket? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_user__logged_)




        //click listeners
        val reserve = findViewById<Button>(R.id.reservePlace)
        reserve.setOnClickListener {
            val intent = Intent(this, ReservationActivity::class.java)
            startActivity(intent)
        }


        socket = ConfirmationWebSocket(this)
    }
}
