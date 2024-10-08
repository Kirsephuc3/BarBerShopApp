package com.example.barbershopapp.data.firebase

import androidx.lifecycle.ViewModel
import com.example.barbershopapp.data.city.City
import com.example.barbershopapp.data.stylist.Stylist
import com.example.barbershopapp.data.user.User
import kotlinx.coroutines.flow.StateFlow

class AuthViewModel(
    private val authRepository: AuthRepo,
    private val cityRepo: CityRepo,
    private val stylistRepo: StylistRepo
) : ViewModel() {
    val user: StateFlow<User?> = authRepository.user
    val cities: StateFlow<List<City>> = cityRepo.cities
    val stylist: StateFlow<List<Stylist>> = stylistRepo.stylist

}
