package com.example.randomuserapp.data.remote

import com.example.randomuserapp.data.remote.dto.RandomUserDto
import retrofit2.http.GET

interface RandomUserApi {

    @GET("api")
    suspend fun getRandomUser(): RandomUserDto
}