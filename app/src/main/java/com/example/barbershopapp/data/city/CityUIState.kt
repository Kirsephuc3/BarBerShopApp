package com.example.barbershopapp.data.city
data class City(
    val id: Int,
    val name: String,
    val addresses: List<String> = emptyList(), // Danh sách địa chỉ
    var selectedAddress: String? = null // Địa chỉ được chọn
)

val cities: List<City> = listOf(
    City(id = 1, name = "Hồ Chí Minh", addresses = listOf("Địa chỉ 1", "Địa chỉ 2")),
    City(id = 2, name = "Hà Nội", addresses = listOf("Địa chỉ 3", "Địa chỉ 4")),
    City(id = 3, name = "Đà Nẵng", addresses = listOf("Địa chỉ 5", "Địa chỉ 6"))
)