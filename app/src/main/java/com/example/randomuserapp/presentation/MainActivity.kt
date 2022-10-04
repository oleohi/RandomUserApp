package com.example.randomuserapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.randomuserapp.presentation.login.ui_components.LoginScreen
import com.example.randomuserapp.presentation.ui.theme.RandomUserAppTheme
import com.example.randomuserapp.presentation.users.ui_components.UsersScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RandomUserAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = NavScreen.LoginScreen.route
                    ) {
                        composable(
                            route = NavScreen.LoginScreen.route
                        ) {
                            LoginScreen(navController = navController)
                        }
                        composable(
                            route = NavScreen.UsersScren.route
                        ) {
                            UsersScreen()
                        }
                    }
                }
            }
        }
    }
}
