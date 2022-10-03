package com.example.randomuserapp.domain.repository

import com.example.randomuserapp.data.remote.dto.RandomUserDto

interface RandomUserRepository {

    suspend fun getRandomUser(): RandomUserDto
}