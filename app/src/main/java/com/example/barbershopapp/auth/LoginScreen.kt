package com.example.barbershopapp.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.barbershopapp.R
import com.example.barbershopapp.components.ButtonComponent
import com.example.barbershopapp.components.ClickableLoginTextComponent
import com.example.barbershopapp.components.DividerTextComponent
import com.example.barbershopapp.components.HeadingTextComponent
import com.example.barbershopapp.components.MyTextFieldComponent
import com.example.barbershopapp.components.NormalTextComponent
import com.example.barbershopapp.components.PasswordFieldComponent
import com.example.barbershopapp.components.UnderLinedTextComponent
import com.example.barbershopapp.navigation.BackButtonHandler
import com.example.barbershopapp.navigation.BarBerShopAppRoute
import com.example.barbershopapp.navigation.Screen


@Composable
fun LoginScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(30.dp)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(22.dp)
            ) {

                HeadingTextComponent(value = stringResource(id = R.string.app_name))
                Spacer(modifier = Modifier.height(12.dp))
                NormalTextComponent(value = stringResource(id = R.string.login))
                MyTextFieldComponent(
                    labelValue = stringResource(id = R.string.phone),
                    painterResource = painterResource(id = R.drawable.phone)

                )
                PasswordFieldComponent(
                    labelValue = stringResource(id = R.string.password),
                    painterResource = painterResource(id = R.drawable.lock)
                )
                Spacer(modifier = Modifier.height(8.dp))

                UnderLinedTextComponent(value = stringResource(id = R.string.forget_password))
                Spacer(modifier = Modifier.height(90.dp))
                ButtonComponent(value = stringResource(id = R.string.login))
                Spacer(modifier = Modifier.height(20.dp))

                DividerTextComponent()
                Spacer(modifier = Modifier.height(60.dp))

                ClickableLoginTextComponent(tryingToLogin = false, onTextSelected = {
                    BarBerShopAppRoute.navigateTo(Screen.RegisterScreen)
                })

            }
        }
        BackButtonHandler {
            BarBerShopAppRoute.navigateTo(Screen.SliderScreen)
        }
    }
}
@Preview(showBackground = true)
@Composable
fun LoginScreenPreview(){
    LoginScreen()
}

