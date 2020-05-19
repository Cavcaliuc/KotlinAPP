package com.example.myapplication.admin.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myapplication.AddPlateActivity
import com.example.myapplication.ConfirmationWebSocket
import com.example.myapplication.R

class MainViewActivity : AppCompatActivity() {
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

//        val listItems = arrayOfNulls<String>(data.size)
//        for (i in 0 until recipeList.size) {
//            val recipe = recipeList[i]
//            listItems[i] = recipe.title
//        }
//        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
//        listView.adapter = adapter


    }


}
