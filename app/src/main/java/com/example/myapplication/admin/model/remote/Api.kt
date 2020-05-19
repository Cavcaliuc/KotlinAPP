package com.example.myapplication.admin.model.remote

import com.example.myapplication.admin.model.data.*
import com.example.myapplication.services.request.LoginRequest
import com.example.myapplication.services.response.BaseResponse
import com.example.myapplication.services.response.LoginResponse
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.*

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

    @GET("/cars/{id}")
    suspend fun getPlateDetails(
        @Header("X-Auth-Token") token: String,
        @Path("id") id: String
    ): GetPlateDetails
}