package com.jluqgon214.app.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.jluqgon214.app.R
import com.jluqgon214.app.components.CustomButton
import com.jluqgon214.app.ui.theme.background
import com.jluqgon214.app.viewModel.loginViewModel


@Composable
fun LoginScreen(navController: NavController, loginViewModel: loginViewModel) {

    val email by loginViewModel.email.observeAsState("")
    val password by loginViewModel.password.observeAsState("")
    val context = LocalContext.current


    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(background)
    ) { paddingValues ->
        16.dp
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(background),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = "Login",
                    fontWeight = FontWeight.Bold,
                    fontSize = 26.sp,
                    color = Color.Black
                )
                Image(
                    painter = painterResource(id = R.drawable.login),
                    contentDescription = null
                )
            }
            //Columna para los campos de texto
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Column {
                    Text(
                        text = "Correo electrónico o Usuario:",
                        color = Color.Black
                    )
                    OutlinedTextField(
                        value = email,
                        onValueChange = { loginViewModel.updateEmail(it) },
                        modifier = Modifier
                    )
                }

                Column {
                    Text(
                        text = "Contraseña: ",
                        color = Color.Black
                    )
                    OutlinedTextField(
                        value = password,
                        onValueChange = { loginViewModel.updatePassword(it) },
                        modifier = Modifier
                    )
                }
            }

            // Fila de botones
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                CustomButton("Iniciar Sesión", onClick = {
                    val registeredUser =
                        loginViewModel.registeredUsers.find { it.email == email && it.password == password }
                    if (registeredUser != null) {
                        // Usuario encontrado, iniciar sesión
                        loginViewModel.updateName(registeredUser.name)
                        Toast.makeText(
                            context,
                            "Bienvenido ${registeredUser.name}",
                            Toast.LENGTH_SHORT
                        ).show()
                        navController.navigate("HomeScreen") // Navegar a la pantalla principal
                    } else {
                        // Usuario no encontrado, mostrar mensaje de error
                        Toast.makeText(context, "Credenciales incorrectas", Toast.LENGTH_SHORT)
                            .show()
                    }
                })
                CustomButton("Registrarse", onClick = {
                    navController.navigate("RegisterScreen")
                })
            }
        }
    }
}