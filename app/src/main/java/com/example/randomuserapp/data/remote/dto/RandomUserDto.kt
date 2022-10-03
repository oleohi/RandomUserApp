package com.example.randomuserapp.data.remote.dto

import com.example.randomuserapp.domain.models.RandomUser

data class RandomUserDto(
    val cell: String,
    val dob: Dob,
    val email: String,
    val gender: String,
    val id: Id,
    val location: Location,
    val login: Login,
    val name: Name,
    val nat: String,
    val phone: String,
    val picture: Picture,
    val registered: Registered
)

fun RandomUserDto.toRandomUser(): RandomUser {
    return RandomUser(
        email = email,
        name = name,
        phone = phone,
        picture = picture
    )
}