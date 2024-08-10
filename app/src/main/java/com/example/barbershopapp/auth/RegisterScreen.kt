package com.example.barbershopapp.auth

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.barbershopapp.R
import com.example.barbershopapp.components.ButtonComponent
import com.example.barbershopapp.components.CheckboxComponent
import com.example.barbershopapp.components.ClickableLoginTextComponent
import com.example.barbershopapp.components.DatePickerDocked
import com.example.barbershopapp.components.DividerTextComponent
import com.example.barbershopapp.components.HeadingTextComponent
import com.example.barbershopapp.components.MailTextFieldComponent
import com.example.barbershopapp.components.MyTextFieldComponent
import com.example.barbershopapp.components.NormalTextComponent
import com.example.barbershopapp.components.PasswordFieldComponent
import com.example.barbershopapp.navigation.BackButtonHandler
import com.example.barbershopapp.navigation.BarBerShopAppRoute
import com.example.barbershopapp.navigation.Screen

@Composable
fun RegisterScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Surface(
            color = Color.White,
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
            ) {
                HeadingTextComponent(value = stringResource(id = R.string.hello))
                Spacer(modifier = Modifier.height(12.dp))
                NormalTextComponent(value = stringResource(id = R.string.create_account))
                Spacer(modifier = Modifier.height(20.dp))
                MyTextFieldComponent(
                    labelValue = stringResource(id = R.string.first_name),
                    painterResource = painterResource(id = R.drawable.person)
                )
                MailTextFieldComponent(
                    labelValue = stringResource(id = R.string.email),
                    painterResource = painterResource(id = R.drawable.mail)
                )
                MyTextFieldComponent(
                    labelValue = stringResource(id = R.string.phone),
                    painterResource = painterResource(id = R.drawable.phone)
                )
                DatePickerDocked(
                    labelValue = stringResource(id = R.string.bỉthday),
                    painterResource = painterResource(id = R.drawable.date)
                )
                PasswordFieldComponent(
                    labelValue = stringResource(id = R.string.password),
                    painterResource = painterResource(id = R.drawable.lock)
                )
                Spacer(modifier = Modifier.height(12.dp))
                CheckboxComponent(value = stringResource(id = R.string.policy), onTextSelected = {
                    BarBerShopAppRoute.navigateTo(Screen.PolicyScreen)
                })
                Spacer(modifier = Modifier.height(70.dp))
                ButtonComponent(value = stringResource(id = R.string.register))
                Spacer(modifier = Modifier.height(20.dp))
                DividerTextComponent()
                Spacer(modifier = Modifier.height(20.dp))
                ClickableLoginTextComponent(tryingToLogin = true, onTextSelected = {
                    BarBerShopAppRoute.navigateTo(Screen.LoginScreen)
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
fun RegisterScreenPreview() {
    RegisterScreen()
}