package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.myapplication.R
import com.example.myapplication.common.SharedPref
import com.example.myapplication.services.ServiceController
import com.example.myapplication.services.request.LoginRequest
import com.example.myapplication.services.response.LoginResponse
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val buttonRegister = findViewById<Button>(R.id.clickREG)
        buttonRegister.setOnClickListener {
            val intent = Intent(this, SignUPActivity::class.java)

            startActivity(intent)
        }

        var email = findViewById<EditText>(R.id.editEmail)
        var pass = findViewById<EditText>(R.id.editPass)
        val loginButton = findViewById<Button>(R.id.buttonLog)

        loginButton.setOnClickListener {
            val data = LoginRequest()
            data.email = email.text.toString()
            data.password = pass.text.toString()
            ServiceController.login(data)
        }
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }
    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(event: LoginResponse) {
        SharedPref.putToken(event.token)
        val intent = Intent(this, PageUser_Logged_Activity::class.java)

        startActivity(intent)

    }

    fun onClick(view: View) {}
}

