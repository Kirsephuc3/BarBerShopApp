package com.example.barbershopapp.Screen.user

import android.app.Service
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.PermIdentity
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.filled.Star
import com.example.barbershopapp.R
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.barbershopapp.data.firebase.AuthRepo
import com.example.barbershopapp.data.firebase.AuthViewModel
import com.example.barbershopapp.data.firebase.AuthViewModelFactory
import com.example.barbershopapp.data.user.UserViewModel
import com.example.barbershopapp.navigation.BarBerShopAppRoute
import com.example.barbershopapp.navigation.Screen
import com.example.barbershopapp.ui.theme.fontFamily1
import com.example.barbershopapp.ui.theme.fontFamily2


sealed class BottomNavItem(val screen : Screen, val icon: ImageVector, val label: String) {
    object Home : BottomNavItem(Screen.HomeScreen, Icons.Default.Home, "Home")
    object Booking : BottomNavItem(Screen.BookScreen, Icons.Default.Timer, "Booking")
    object Profile : BottomNavItem(Screen.ProfileScreen, Icons.Default.Person, "Profile")
    object Stylist : BottomNavItem(Screen.StylistScreen, Icons.Default.PermIdentity,"Barber")
    object History : BottomNavItem(Screen.HistoryScreen, Icons.Default.History, "history")
}

@Composable
fun SppokyAppBottomNavigation(
) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Stylist,
        BottomNavItem.Booking,
        BottomNavItem.History,
        BottomNavItem.Profile
    )

    NavigationBar(
        containerColor = Color.White,
        contentColor = Color.Black,
        tonalElevation = 8.dp
    ) {
        items.forEach { screenItem ->
            NavigationBarItem(
                icon = { Icon(screenItem.icon, contentDescription = screenItem.label) },
                label = { Text(screenItem.label, fontSize = 12.sp, fontWeight = FontWeight.Bold) },
                selected = BarBerShopAppRoute.currentScreen.value == screenItem.screen,
                onClick = {
                    BarBerShopAppRoute.currentScreen.value = screenItem.screen
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar(username: String) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.img),
                        contentDescription = "User Avatar",
                        modifier = Modifier
                            .size(48.dp)
                            .clip(CircleShape)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text(text = username, fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color.White)
                    }
                }
                IconButton(onClick = {  }) {
                    Icon(
                        painter = painterResource(id = R.drawable.img_1),
                        contentDescription = "Notification"
                    )
                }
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color(0xFF1F4591)
        ),
        modifier = Modifier.background(Color(0xFF1F4591)),
    )
}

@Composable
fun ServiceColumn(
    imageResource : Int,
    contentDescription : String,
    serviceName : String,
    modifier : Modifier = Modifier
){
    Column (
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(color = Color.White)
            .shadow(
                3.dp,
                RoundedCornerShape(10.dp)
            )
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = contentDescription,
            modifier = modifier.size(130.dp)
        )
        Text(text = serviceName, fontWeight = FontWeight.Bold, fontSize = 20.sp, color = Color.Blue)
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ServiceFlow(){
    FlowRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .padding(top = 100.dp)
    ) {
        ServiceColumn(imageResource = R.drawable.cattoc, contentDescription = "Cắt tóc", serviceName = "Cắt tóc")
        ServiceColumn(imageResource = R.drawable.uontoc, contentDescription = "Uốn tóc", serviceName = "Uốn tóc")
        ServiceColumn(imageResource = R.drawable.duoitoc, contentDescription = "Duỗi tóc", serviceName = "Duỗi tóc")
        ServiceColumn(imageResource = R.drawable.goidau, contentDescription = "Gọi đầu", serviceName = "Gọi đầu")
    }
}

@Composable
fun BodyContent() {
    val colorStops = arrayOf(
        0.1f to Color(0xFF7AEFF7),
        0.4f to Color.White,
        0.7f to Color(0xFFF4D0FA),
        1f to Color(0xFF7AEFF7)
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(RoundedCornerShape(12.dp))
    ) {
        Box(
            modifier = Modifier
                .height(140.dp)
                .fillMaxWidth()
                .padding(8.dp)
                .background(Brush.horizontalGradient(colorStops = colorStops))
                .clip(RoundedCornerShape(12.dp))
                .clickable { BarBerShopAppRoute.navigateTo(Screen.HistoryScreen) }
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 8.dp)
                    .align(Alignment.TopStart), // Căn chỉnh phần ảnh và chữ ở trên cùng
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.anhnu),
                    contentDescription = "Custom Image",
                    modifier = Modifier
                        .size(67.dp)
                        .padding(1.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column(
                    modifier = Modifier
                        .weight(1f) // Đảm bảo phần nội dung chiếm không gian còn lại
                ) {
                    Text(
                        text = "MỜI BẠN ĐÁNH GIÁ CHẤT LƯỢNG PHỤC VỤ",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        fontFamily = fontFamily1,
                    )
                    Text(
                        text = "Phản hồi của bạn giúp chúng tôi cải thiện dịch vụ",
                        fontSize = 14.sp,
                        fontFamily = fontFamily2
                    )
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomStart)
                    .padding(start = 80.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    repeat(5) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "Star",
                            tint = Color.Yellow,
                            modifier = Modifier.size(30.dp)
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = R.drawable.voucher2),
            contentDescription = "Discount",
            modifier = Modifier
                .height(230.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "DỊCH VỤ TÓC",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.Blue
        )
        ServiceFlow()
    }
}

@Composable
fun UserHomeScreen() {
    val authRepo = AuthRepo()
    val authViewModel: AuthViewModel = viewModel(
        factory = AuthViewModelFactory(authRepo)
    )

    val user by authViewModel.user.collectAsState()

    val username = user?.name ?: "GUEST"


    Scaffold(
        bottomBar = {
            SppokyAppBottomNavigation()
        },
        topBar = {
            CustomTopBar(username = username)
        }
    ) {
            innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            BodyContent()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserHomePreview() {
    UserHomeScreen()
}