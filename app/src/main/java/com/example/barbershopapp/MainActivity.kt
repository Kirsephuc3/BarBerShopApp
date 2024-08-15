package com.example.barbershopapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.barbershopapp.Screen.MyApp
import com.example.barbershopapp.app.BarBerShopApp
import com.example.barbershopapp.auth.LoginScreen
import com.example.barbershopapp.auth.RegisterScreen
import com.example.barbershopapp.navigation.Screen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BarBerShopApp()
        }
    }
}
