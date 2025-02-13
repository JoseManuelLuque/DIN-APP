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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.jluqgon214.app.R
import com.jluqgon214.app.components.CustomButton
import com.jluqgon214.app.model.User
import com.jluqgon214.app.ui.theme.background
import com.jluqgon214.app.viewModel.loginViewModel

@Composable
fun RegisterScreen(navController: NavHostController, loginViewModel: loginViewModel) {
    val name by loginViewModel.name.observeAsState("")
    val email by loginViewModel.email.observeAsState("")
    val password by loginViewModel.password.observeAsState("")
    val confirmPassword by loginViewModel.confirmPassword.observeAsState("")
    val context = LocalContext.current


    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(background)
    ) { paddingValues ->
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
                    text = "Register",
                    fontWeight = FontWeight.Bold,
                    fontSize = 26.sp,
                    color = Color.Black
                )
                Image(
                    painter = painterResource(id = R.drawable.register),
                    contentDescription = null
                )
            }
            //Columna para los campos de texto
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .weight(2f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = "Nombre de usuario:",
                    color = Color.Black
                )
                OutlinedTextField(
                    value = name,
                    onValueChange = { loginViewModel.updateName(it) },
                    modifier = Modifier
                )

                Text(
                    text = "Correo electrónico:",
                    color = Color.Black
                )
                OutlinedTextField(
                    value = email,
                    onValueChange = { loginViewModel.updateEmail(it) },
                    modifier = Modifier
                )

                Text(
                    text = "Contraseña: ",
                    color = Color.Black
                )
                OutlinedTextField(
                    value = password,
                    onValueChange = { loginViewModel.updatePassword(it) },
                    modifier = Modifier
                )

                Text(
                    text = "Repetir Contraseña: ",
                    color = Color.Black
                )
                OutlinedTextField(
                    value = confirmPassword,
                    onValueChange = { loginViewModel.updateConfirmPassword(it) },
                    modifier = Modifier
                )
            }

            // Fila de botones
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.3f),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                CustomButton("Limpiar Campos", onClick = {
                    loginViewModel.updateName("")
                    loginViewModel.updateEmail("")
                    loginViewModel.updatePassword("")
                })
                CustomButton("Registrarse", onClick = {
                    if (password == confirmPassword) {
                        //TODO: Registrar usuario
                        loginViewModel.registerUser(User(email, password, name))
                        navController.navigate("LoginScreen")
                    }
                    else {
                        Toast.makeText(context, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                    }
                })
            }
        }
    }
}