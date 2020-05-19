package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AddPlateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_plate)

        val buttonConfim = findViewById<Button>(R.id.sendConfirm)
        buttonConfim.setOnClickListener {
            val intent = Intent(this, PlateActivity::class.java)

            startActivity(intent)
        }
    }
}
