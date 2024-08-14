package com.example.barbershopapp.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.barbershopapp.Screen.HomeScreen
import com.example.barbershopapp.Screen.User.MyApp
import com.example.barbershopapp.auth.LoginScreen
import com.example.barbershopapp.auth.PolicyScreen
import com.example.barbershopapp.auth.RegisterScreen
import com.example.barbershopapp.navigation.BarBerShopAppRoute
import com.example.barbershopapp.navigation.Screen

@Composable
fun BarBerShopApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Crossfade(targetState = BarBerShopAppRoute.currentScreen.value, label = "") { currentState ->
            when (currentState) {
                is Screen.SliderScreen -> {
                    MyApp(
                        onRegisterClick = { BarBerShopAppRoute.currentScreen.value = Screen.RegisterScreen },
                        onLoginClick = { BarBerShopAppRoute.currentScreen.value = Screen.LoginScreen }
                    )
                }
                is Screen.RegisterScreen -> {
                    RegisterScreen()
                }
                is Screen.PolicyScreen -> {
                    PolicyScreen()
                }
                is Screen.LoginScreen -> {
                   LoginScreen()
                }
                is Screen.HomeScreen -> {
                    HomeScreen()
                }
            }
        }
    }
}