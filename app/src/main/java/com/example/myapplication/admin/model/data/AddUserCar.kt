package com.example.myapplication.admin.model.data


import com.google.gson.annotations.SerializedName

data class AddUserCar(
    @SerializedName("data")
    val `data`: UserCarData,
    @SerializedName("success")
    val success: Boolean
)