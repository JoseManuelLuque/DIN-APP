package com.jluqgon214.app.components.AppBars

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.jluqgon214.app.ui.theme.ColorIconos
import com.jluqgon214.app.ui.theme.ColorIconos2
import com.jluqgon214.app.ui.theme.ColorTextoSecundario
import com.jluqgon214.app.ui.theme.ColorTextoSeleccionado
import com.jluqgon214.app.ui.theme.Fondo
import com.jluqgon214.app.ui.theme.NaranjaOscuro
import com.jluqgon214.app.viewModel.loginViewModel
import androidx.compose.runtime.livedata.observeAsState

@Composable
fun BottomNavigationBar(navController: NavController, loginViewModel: loginViewModel) {
    val selectedItem by loginViewModel.selectedBottomBarItem.observeAsState(0)
    val items = listOf("Inicio", "Opciones")
    val selectedIcons =
        listOf(
            Icons.Filled.Home,
            Icons.Filled.Settings
        )
    val unselectedIcons = listOf(
        Icons.Outlined.Home,
        Icons.Outlined.Settings
    )

    NavigationBar(
        modifier = Modifier
            .fillMaxWidth(),
        containerColor = Fondo,

        ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        if (selectedItem == index) selectedIcons[index] else unselectedIcons[index],
                        contentDescription = item,
                    )
                },
                label = {
                    if (selectedItem == index) {
                        Text(
                            item,
                            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 12.sp)
                        )
                    } else {
                        Text(item, style = TextStyle(fontSize = 12.sp))
                    }

                },
                selected = selectedItem == index,
                onClick = {
                    loginViewModel.updateSelectedBottomBarItem(index)
                    if (selectedItem == 0) {
                        navController.navigate("HomeScreen")
                        loginViewModel.updateSelectedBottomBarItem(0)
                    } else {
                        navController.navigate("SettingsScreen")
                        loginViewModel.updateSelectedBottomBarItem(1)
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = NaranjaOscuro,
                    selectedIconColor = ColorIconos,
                    selectedTextColor = ColorTextoSeleccionado,
                    unselectedTextColor = ColorTextoSecundario,
                    unselectedIconColor = ColorIconos2
                )
            )
        }

    }
}
