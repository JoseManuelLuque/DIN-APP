package com.jluqgon214.app.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.jluqgon214.app.R

@Composable
fun Cover(navController: NavController, modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.app_cover),
        contentDescription = "Portada App",
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .fillMaxWidth()
            .clickable { navController.navigate("LoginScreen") }
    )
}