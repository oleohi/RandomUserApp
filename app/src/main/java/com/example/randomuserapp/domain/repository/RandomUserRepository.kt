package com.example.randomuserapp.domain.repository

import com.example.randomuserapp.data.remote.dto.ResultDto

interface RandomUserRepository {

    suspend fun getRandomUser(): ResultDto
}