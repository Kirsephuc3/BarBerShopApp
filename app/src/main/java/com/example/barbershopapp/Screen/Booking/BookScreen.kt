package com.example.barbershopapp.Screen.Booking

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.House
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.barbershopapp.R
import com.example.barbershopapp.components.AppToolbar
import com.example.barbershopapp.components.DynamicSelectTextField
import com.example.barbershopapp.data.city.cities


@Composable
fun BookScreen() {
    val options = remember { cities.map { it.name } }
    var selectedCityName by remember { mutableStateOf<String?>(null) }

    Scaffold(
        topBar = {
            AppToolbar(
                toolbarTitle = stringResource(R.string.booking),
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Filled.House,
                        contentDescription = stringResource(R.string.menu),
                        tint = Color.Black
                    )
                },
                onNavigationIconClicked = {
                    // Xử lý sự kiện khi icon navigation được bấm
                },
                actions = {
                    IconButton(onClick = {
                        // Xử lý sự kiện khi icon logout được bấm
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Logout,
                            contentDescription = stringResource(R.string.logout),
                            tint = Color.Black
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(paddingValues)
        ) {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(32.dp)) {

                // Sử dụng DynamicSelectTextField với giá trị mặc định là null
                DynamicSelectTextField(
                    selectedValue = selectedCityName,
                    options = options,
                    label = stringResource(id = R.string.city),  // Hiển thị "City"
                    onValueChangedEvent = { newCityName ->
                        selectedCityName = newCityName
                    }
                )

                selectedCityName?.let { selectedCityName ->
                    val selectedCity = cities.find { it.name == selectedCityName }
                    selectedCity?.let { city ->
                        LazyColumn(modifier = Modifier.padding(top = 16.dp)) {
                            items(city.addresses) { address ->
                                AddressBox(
                                    address = address,
                                    isSelected = city.selectedAddress == address,
                                    onClick = {
                                        city.selectedAddress = address
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun AddressBox(
    address: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .background(if (isSelected) Color.Blue else Color.Gray)
            .clickable(onClick = onClick),
        color = Color.LightGray
    ) {
        Text(
            text = address,
            modifier = Modifier.padding(16.dp),
            color = if (isSelected) Color.White else Color.Black
        )
    }
}
@Preview(showBackground = true)
@Composable
fun BookScreenPreview() {
    BookScreen()
}