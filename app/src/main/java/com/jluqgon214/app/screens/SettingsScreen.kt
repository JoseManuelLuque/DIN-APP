package com.jluqgon214.app.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.jluqgon214.app.components.AppBars.BottomNavigationBar
import com.jluqgon214.app.components.AppBars.TopAppBar
import com.jluqgon214.app.components.CustomButton
import com.jluqgon214.app.ui.theme.Fondo
import com.jluqgon214.app.viewModel.loginViewModel

@Composable
fun SettingsScreen(navController: NavHostController, loginViewModel: loginViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(loginViewModel, "Configuración")
        },
        bottomBar = {
            BottomNavigationBar(navController, loginViewModel)
        }
    ) { padding -> 16.dp
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Fondo)
                .padding(padding),
            verticalArrangement =  Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column {
                CustomButton("Cerrar Sesión", onClick = {
                    navController.navigate("login")
                })
            }

        }
    }
}