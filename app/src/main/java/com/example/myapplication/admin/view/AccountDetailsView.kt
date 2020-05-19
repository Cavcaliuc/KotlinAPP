package com.example.myapplication.admin.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_account_details.*

class AccountDetailsView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_details)

        //extract data from intent
        val token = if (savedInstanceState == null) {
            val extras = getIntent().extras
            extras?.getString("token")
        } else {
            savedInstanceState.getSerializable("token") as String?
        }

        val userId = if (savedInstanceState == null) {
            val extras = getIntent().extras
            extras?.getString("user_id")
        } else {
            savedInstanceState.getSerializable("user_id") as String?
        }

        add_plate.setOnClickListener {
            val intent = Intent(this, AddPlateView::class.java)
            intent.putExtra("token", token)
            intent.putExtra("user_id", userId)
            startActivity(intent)
        }
    }
}