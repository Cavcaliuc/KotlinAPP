package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myapplication.R

class AdminActivity : AppCompatActivity() {
    private var socket: ConfirmationWebSocket? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        socket = ConfirmationWebSocket(this)

        val button4 = findViewById<Button>(R.id.addAccount)
        button4.setOnClickListener {
            val intent = Intent(this, AddPlateActivity::class.java)

            startActivity(intent)
        }


    }
}
