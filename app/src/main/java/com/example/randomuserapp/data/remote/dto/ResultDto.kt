package com.example.randomuserapp.data.remote.dto

import com.example.randomuserapp.domain.models.RandomUser

data class ResultDto(
    val results: List<RandomUserDto>,
    val info: ResultInfo
)

fun ResultDto.toRandomUsers(): List<RandomUser> {
    return listOf(
        RandomUser(
            email = results[0].email,
            name = results[0].name,
            phone = results[0].phone,
            picture = results[0].picture
        )
    )
}

