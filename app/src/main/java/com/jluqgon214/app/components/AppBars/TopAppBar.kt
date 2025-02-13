package com.jluqgon214.app.components.AppBars

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.jluqgon214.app.ui.theme.TextoBlanco
import com.jluqgon214.app.ui.theme.orange
import com.jluqgon214.app.viewModel.loginViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(viewModel: loginViewModel, titulo: String) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(orange)
            .systemBarsPadding(),
        contentAlignment = Center,
    ){
        Text(
            text = titulo,
            color = TextoBlanco,
            textAlign = TextAlign.Center,
        )
    }

}