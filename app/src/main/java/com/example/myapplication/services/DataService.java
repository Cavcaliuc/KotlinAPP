package com.example.myapplication.services;

import com.example.myapplication.services.request.LoginRequest;
import com.example.myapplication.services.response.BaseResponse;
import com.example.myapplication.services.response.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface DataService {

    @POST("/authenticate")
    Call<BaseResponse<LoginResponse>> login(@Body LoginRequest r);

}
