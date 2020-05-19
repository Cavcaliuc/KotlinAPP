package com.example.myapplication.admin.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.common.SharedPref
import com.example.myapplication.services.ServiceController
import com.example.myapplication.services.request.LoginRequest
import com.example.myapplication.services.response.LoginResponse
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class LoginViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        var email = findViewById<EditText>(R.id.editEmail)
        var pass = findViewById<EditText>(R.id.editPass)
        val loginButton = findViewById<Button>(R.id.buttonLog)

        //observe view model
        loginviewmodel = ViewModelProvider(this).get(LoginViewModel0::class.java)
        loginviewmodel.userDetails.observe(this, Observer {
            val id = it
            val intent = Intent(this, LoginActivity1::class.java)
            intent.putExtra("azureId", id)
            startActivity(intent)
        })

        loginButton.setOnClickListener {
            val data = LoginRequest()
            data.email = email.text.toString()
            data.password = pass.text.toString()
            ServiceController.login(data)
        }
    }



    fun onClick(view: View) {}
}

