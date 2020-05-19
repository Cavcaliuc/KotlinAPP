package com.example.myapplication.admin.model.data


import com.google.gson.annotations.SerializedName

data class AddUser(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("success")
    val success: Boolean
)