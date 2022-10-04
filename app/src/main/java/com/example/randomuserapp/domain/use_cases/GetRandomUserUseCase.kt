package com.example.randomuserapp.domain.use_cases

import com.example.randomuserapp.data.remote.dto.toRandomUsers
import com.example.randomuserapp.domain.models.RandomUser
import com.example.randomuserapp.domain.repository.RandomUserRepository
import com.example.randomuserapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetRandomUserUseCase @Inject constructor(
    private val repository: RandomUserRepository
) {

    fun execute(): Flow<Resource<List<RandomUser>>> = flow {
        try {
            emit(Resource.Loading())
            val users = repository.getRandomUser().toRandomUsers()
            emit(Resource.Success(users))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred."))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }
}