package com.example.randomuserapp.presentation.users

import com.example.randomuserapp.domain.models.RandomUser

data class UserState(
    val isLoading: Boolean = false,
    val user: RandomUser? = null,
    val error: String = ""
)