package com.example.randomuserapp.presentation

import com.example.randomuserapp.util.Constants.LOGIN_SCREEN_ROUTE
import com.example.randomuserapp.util.Constants.USERS_SCREEN_ROUTE

sealed class NavScreen(val route: String) {
    object LoginScreen : NavScreen(LOGIN_SCREEN_ROUTE)
    object UsersScren : NavScreen(USERS_SCREEN_ROUTE)
}
