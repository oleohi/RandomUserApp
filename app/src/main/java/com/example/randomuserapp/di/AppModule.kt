package com.example.randomuserapp.di

import com.example.randomuserapp.data.remote.RandomUserApi
import com.example.randomuserapp.data.repository.RandomUserRepositoryImpl
import com.example.randomuserapp.domain.repository.RandomUserRepository
import com.example.randomuserapp.domain.use_cases.validation.ValidateEmailUseCase
import com.example.randomuserapp.domain.use_cases.validation.ValidatePasswordUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object AppModule {

    @Provides
    @ViewModelScoped
    fun provideRandomUserRepository(api: RandomUserApi): RandomUserRepository =
        RandomUserRepositoryImpl(api)

    @Provides
    @ViewModelScoped
    fun provideValidateEmailUseCase() = ValidateEmailUseCase()

    @Provides
    @ViewModelScoped
    fun provideValidatePasswordUseCase() = ValidatePasswordUseCase()

}