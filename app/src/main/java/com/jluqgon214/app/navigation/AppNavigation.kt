package com.jluqgon214.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jluqgon214.app.screens.Cover
import com.jluqgon214.app.screens.LoginScreen
import com.jluqgon214.app.screens.RegisterScreen
import com.jluqgon214.app.viewModel.loginViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jluqgon214.app.screens.HomeScreen
import com.jluqgon214.app.screens.SettingsScreen

@Composable
fun AppNavigation(modifier: Modifier) {
    val navController = rememberNavController()


    val loginViewModel: loginViewModel = viewModel<loginViewModel>()

    NavHost(navController = navController, startDestination = "Cover") {
        composable("Cover") {
            Cover(navController, modifier)
        }
        composable("LoginScreen") {
            LoginScreen(navController, loginViewModel)
        }
        composable("RegisterScreen") {
            RegisterScreen(navController, loginViewModel)
        }
        composable("HomeScreen") {
            HomeScreen(navController, loginViewModel)
        }
        composable("SettingsScreen") {
            SettingsScreen(navController, loginViewModel)
        }


    }
}