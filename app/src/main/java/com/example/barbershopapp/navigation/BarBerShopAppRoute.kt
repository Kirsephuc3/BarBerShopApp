package com.example.barbershopapp.navigation

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.navigation.NavHostController

sealed class Screen {
    object RegisterScreen : Screen()
    object PolicyScreen : Screen()
    object LoginScreen : Screen()
    object SliderScreen : Screen()

}

object BarBerShopAppRoute {
    var currentScreen: MutableState<Screen> = mutableStateOf(Screen.SliderScreen)

    fun navigateTo(destination: Screen) {
        Log.d("BarBerShopAppRoute", "Navigating to: $destination")
        currentScreen.value = destination
    }
}