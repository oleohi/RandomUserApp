package com.example.randomuserapp.presentation.users

import androidx.compose.runtime.mutableStateListOf
import com.example.randomuserapp.domain.models.RandomUser

data class UserState(
    val isLoading: Boolean = false,
    val users: List<RandomUser> = emptyList(),
    val error: String = "",
    val allUsers: List<RandomUser> = emptyList()
)