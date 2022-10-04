package com.example.randomuserapp.data.remote

import com.example.randomuserapp.data.remote.dto.ResultDto
import retrofit2.http.GET

interface RandomUserApi {

    @GET("api")
    suspend fun getRandomUser(): ResultDto
}