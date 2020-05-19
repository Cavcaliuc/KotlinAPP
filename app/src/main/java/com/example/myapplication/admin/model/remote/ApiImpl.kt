package com.example.myapplication.admin.model.remote

import com.example.myapplication.admin.model.data.AddUser
import com.example.myapplication.admin.model.data.AddUserCar
import com.example.myapplication.admin.model.data.AdminAccountList
import com.example.myapplication.admin.model.data.Login
import com.google.gson.JsonElement
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Header

class ApiImpl : Api{
    private val api = Retrofit.Builder()
        .baseUrl("http://25.57.227.183:8080")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(Api::class.java)

    override suspend fun getAccountList(token: String): AdminAccountList {
        return api.getAccountList(token)
    }

    override suspend fun login(body: JsonElement): Login {
        return api.login(body)
    }

    override suspend fun addUser(
        @Header(value = "X-Auth-Token") token: String,
        @Body body: JsonElement
    ): AddUser {
        return api.addUser(token, body)
    }

    override suspend fun addUserCar(token: String, body: JsonElement): AddUserCar {
        return api.addUserCar(token, body)
    }

}