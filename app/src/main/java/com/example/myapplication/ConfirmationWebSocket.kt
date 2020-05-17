package com.example.myapplication

import android.app.Activity
import android.app.AlertDialog
import android.widget.Toast
import com.example.myapplication.consts.Consts
import com.example.myapplication.consts.Session.JSESSIONID
import com.example.myapplication.socket.CustomWebSocket
import tech.gusavila92.websocketclient.WebSocketClient
import java.net.URI
import java.net.URISyntaxException


class ConfirmationWebSocket(private val activity: Activity) {
    private var webSocketClient: WebSocketClient? = null

    init {
        try {
            val uri = URI(Consts.WS_CONFIRMATION_URI)
            webSocketClient = object : CustomWebSocket(uri) {
                override fun onTextReceived(message: String?) {
                    println("text received")
                    println(message)
                    showDialog()
                }
            }
            webSocketClient?.addHeader("Cookie", "JSESSIONID=$JSESSIONID")
            webSocketClient?.enableAutomaticReconnection(500)
            webSocketClient?.connect()
        } catch (e: URISyntaxException) {
            e.printStackTrace()
        }
    }

    private fun showDialog() {
        activity.runOnUiThread {
            AlertDialog.Builder(activity)
                .setTitle("Title")
                .setMessage("Is the car at the barrier?")
                .setPositiveButton("Yes") { dialog, whichButton ->

                    webSocketClient?.send("OK")

                }
                .setNegativeButton("No") { dialog, whichButton ->

                    webSocketClient?.send("NO")

                }.show()
        }
    }
}