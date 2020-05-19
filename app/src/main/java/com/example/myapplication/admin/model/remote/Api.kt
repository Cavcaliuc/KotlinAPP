package com.example.myapplication.admin.model.remote

import com.example.myapplication.admin.model.data.AddUser
import com.example.myapplication.admin.model.data.AddUserCar
import com.example.myapplication.admin.model.data.AdminAccountList
import com.example.myapplication.admin.model.data.Login
import com.example.myapplication.services.request.LoginRequest
import com.example.myapplication.services.response.BaseResponse
import com.example.myapplication.services.response.LoginResponse
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface Api{
    @GET("/userList")
    suspend fun getAccountList(
        @Header("X-Auth-Token") token: String
    ): AdminAccountList

    @POST("/authenticate")
    suspend fun login(
        @Body body: JsonElement
    ): Login

    @POST("/addUser")
    suspend fun addUser(
        @Header("X-Auth-Token") token: String,
        @Body body: JsonElement
    ): AddUser

    @POST("/addUserCar")
    suspend fun addUserCar(
        @Header("X-Auth-Token") token: String,
        @Body body: JsonElement
    ): AddUserCar
}