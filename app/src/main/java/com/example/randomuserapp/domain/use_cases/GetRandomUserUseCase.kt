package com.example.randomuserapp.domain.use_cases

import com.example.randomuserapp.data.remote.dto.toRandomUser
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

    fun execute(): Flow<Resource<RandomUser>> = flow {
        try {
            emit(Resource.Loading<RandomUser>())
            val user = repository.getRandomUser().toRandomUser()
            emit(Resource.Success<RandomUser>(user))
        } catch (e: HttpException) {
            emit(Resource.Error<RandomUser>(e.localizedMessage ?: "An unexpected error occurred."))
        } catch (e: IOException) {
            emit(Resource.Error<RandomUser>("Couldn't reach server. Check your internet connection"))
        }
    }
}