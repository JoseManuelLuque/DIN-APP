package com.jluqgon214.app.components

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.jluqgon214.app.ui.theme.orange

@Composable
fun CustomButton(texto: String, onClick: () -> Unit) {
    Button(
        onClick = {
            // Acción al hacer clic en el botón
            onClick()
        },
        colors = ButtonColors(
            containerColor = orange,
            contentColor = Color.White,
            disabledContainerColor = orange,
            disabledContentColor = Color.Black
        )
    ) {
        Text(text = texto)
    }
}