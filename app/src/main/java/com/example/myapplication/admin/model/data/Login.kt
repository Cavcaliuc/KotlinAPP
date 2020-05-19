package com.example.myapplication.admin.model.data


import com.google.gson.annotations.SerializedName

data class Login(
    @SerializedName("data")
    val `data`: DataX,
    @SerializedName("success")
    val success: Boolean
)