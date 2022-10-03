package com.example.randomuserapp.domain.models

import com.example.randomuserapp.data.remote.dto.*

data class RandomUser(
    val email: String,
    val name: Name,
    val phone: String,
    val picture: Picture,
)
