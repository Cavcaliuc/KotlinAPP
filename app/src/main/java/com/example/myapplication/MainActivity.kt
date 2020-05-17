package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private var socket: ConfirmationWebSocket? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.admin1)

        button.setOnClickListener {
            val intent = Intent(this, SignUPActivity::class.java)

            startActivity(intent)
        }

        val button1 = findViewById<Button>(R.id.user)

        button1.setOnClickListener {
            val intent = Intent(this, UserActivity::class.java)

            startActivity(intent)
        }




        socket = ConfirmationWebSocket(this)
    }

    fun onClick(view: View) {}
}
