package com.example.myapplication.admin.model


import com.google.gson.annotations.SerializedName

data class adminAccountList(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("success")
    val success: Boolean
)