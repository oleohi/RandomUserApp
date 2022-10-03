package com.example.randomuserapp.data.repository

import com.example.randomuserapp.data.remote.RandomUserApi
import com.example.randomuserapp.data.remote.dto.RandomUserDto
import com.example.randomuserapp.domain.repository.RandomUserRepository
import javax.inject.Inject

class RandomUserRepositoryImpl @Inject constructor(
    private val api: RandomUserApi
) : RandomUserRepository {

    override suspend fun getRandomUser(): RandomUserDto {
        return api.getRandomUser()
    }
}