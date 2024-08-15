package com.example.barbershopapp.data.firebase

import androidx.lifecycle.ViewModel
import com.example.barbershopapp.data.user.User
import kotlinx.coroutines.flow.StateFlow

class AuthViewModel(private val authRepository: AuthRepo) : ViewModel() {
    val user: StateFlow<User?> = authRepository.user
}
