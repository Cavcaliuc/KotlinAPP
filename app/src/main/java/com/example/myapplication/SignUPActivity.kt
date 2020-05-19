package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

class SignUPActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_u_p)

        val clickLogin = findViewById<Button>(R.id.click_to_login)
        clickLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)

            startActivity(intent)
        }


        var email = findViewById<EditText>(R.id.editTextEmail)
        var pass = findViewById<EditText>(R.id.editTextPassword)
        var name = findViewById<EditText>(R.id.editTextName)
        val signUp = findViewById<Button>(R.id.buttonSignUp)

        signUp.setOnClickListener {
            val data = LoginRequest()
            data.email = email.text.toString()
            data.password = pass.text.toString()
            data.name = name.text.toString()
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
}
