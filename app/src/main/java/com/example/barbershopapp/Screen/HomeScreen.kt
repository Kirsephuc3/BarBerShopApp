package com.example.barbershopapp.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.barbershopapp.R
import com.example.barbershopapp.components.HeadingTextComponent

@Composable
fun HomeScreen() {
    Surface(modifier = Modifier
    .fillMaxSize()
    .background(color = Color.White)
    .padding(16.dp)) {

        HeadingTextComponent(value = stringResource(id = R.string.home))
    }

}