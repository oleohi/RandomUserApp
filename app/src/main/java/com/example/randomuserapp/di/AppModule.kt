package com.example.randomuserapp.di

import com.example.randomuserapp.data.remote.RandomUserApi
import com.example.randomuserapp.data.repository.RandomUserRepositoryImpl
import com.example.randomuserapp.domain.repository.RandomUserRepository
import com.example.randomuserapp.domain.use_cases.validation.ValidateEmailUseCase
import com.example.randomuserapp.domain.use_cases.validation.ValidatePasswordUseCase
import com.example.randomuserapp.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRandomUserApi(): RandomUserApi {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)

        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()
            .create(RandomUserApi::class.java)
    }



    @Provides
    @Singleton
    fun provideRandomUserRepository(api: RandomUserApi): RandomUserRepository =
        RandomUserRepositoryImpl(api)

    @Provides
    @Singleton
    fun provideValidateEmailUseCase() = ValidateEmailUseCase()

    @Provides
    @Singleton
    fun provideValidatePasswordUseCase() = ValidatePasswordUseCase()

}