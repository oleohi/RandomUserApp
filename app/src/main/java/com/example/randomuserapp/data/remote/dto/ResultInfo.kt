package com.example.randomuserapp.data.remote.dto

data class ResultInfo(
    val seed: String,
    val results: Int,
    val page: Int,
    val version: String
)
