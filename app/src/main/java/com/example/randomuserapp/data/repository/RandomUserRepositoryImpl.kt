package com.example.randomuserapp.data.repository

import com.example.randomuserapp.data.remote.RandomUserApi
import com.example.randomuserapp.data.remote.dto.ResultDto
import com.example.randomuserapp.domain.repository.RandomUserRepository
import javax.inject.Inject

class RandomUserRepositoryImpl @Inject constructor(
    private val api: RandomUserApi
) : RandomUserRepository {

    override suspend fun getRandomUser(): ResultDto {
        return api.getRandomUser()
    }
}