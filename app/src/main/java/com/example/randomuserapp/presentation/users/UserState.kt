package com.example.randomuserapp.presentation.users

import com.example.randomuserapp.domain.models.RandomUser

data class UserState(
    val isLoading: Boolean = false,
    val users: List<RandomUser> = emptyList(),
    val error: String = ""
)