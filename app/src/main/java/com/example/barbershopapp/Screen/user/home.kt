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
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.PermIdentity
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.TopAppBar
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
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import com.example.barbershopapp.Screen.user.history.historyScreen
import com.example.barbershopapp.ui.theme.TextColor
import com.example.barbershopapp.ui.theme.fontFamily1
import com.example.barbershopapp.ui.theme.fontFamily2
import com.google.accompanist.flowlayout.FlowRow


sealed class BottomNavItem(val route: String, val icon: ImageVector, val label: String) {
    object Home : BottomNavItem("home", Icons.Default.Home, "Home")
    object Booking : BottomNavItem("booking", Icons.Default.Timer, "Booking")
    object Profile : BottomNavItem("profile", Icons.Default.Person, "Profile")
    object Barber : BottomNavItem("barber", Icons.Default.PermIdentity,"Barber")
    object History : BottomNavItem("history", Icons.Default.History, "history")
}

@Composable
fun SppokyAppBottomNavigation(
    navController: NavHostController,
    items: List<BottomNavItem>
) {
    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Color.Black,
        elevation = 8.dp
    ) {
        val currentRoute = currentRoute(navController)
        items.forEach { screen ->
            BottomNavigationItem(
                icon = { Icon(screen.icon, contentDescription = screen.label) },
                label = {
                    Text(
                        screen.label, fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    ) },
                selected = currentRoute == screen.route,
                selectedContentColor = Color.Blue,
                unselectedContentColor = Color.LightGray,
                onClick = {
                    if (currentRoute != screen.route) {
                        navController.navigate(screen.route) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                }
            )
        }
    }
}

@Composable
fun CustomTopBar() {
    TopAppBar(
        backgroundColor = Color(0xFF1F4591),
        contentColor = Color.White,
        elevation = 4.dp,
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
                        Text(text = "GUEST", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color.White)
                    }
                }
                IconButton(onClick = {  }) {
                    Icon(
                        painter = painterResource(id = R.drawable.img_1),
                        contentDescription = "Notification"
                    )
                }
            }
        }
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

@Composable
fun ServiceFlow(){
    FlowRow(
        mainAxisSpacing = 16.dp,
        crossAxisSpacing = 16.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .padding(top = 130.dp)
    ) {
        ServiceColumn(imageResource = R.drawable.cattoc, contentDescription = "Cắt tóc", serviceName = "Cắt tóc")
        ServiceColumn(imageResource = R.drawable.uontoc, contentDescription = "Uốn tóc", serviceName = "Uốn tóc")
        ServiceColumn(imageResource = R.drawable.duoitoc, contentDescription = "Duỗi tóc", serviceName = "Duỗi tóc")
        ServiceColumn(imageResource = R.drawable.goidau, contentDescription = "Gọi đầu", serviceName = "Gọi đầu")
    }
}

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController, startDestination = "home") {
        composable("home") { BodyContent(navController) }
        composable("history") { historyScreen() }
    }
}

@Composable
fun BodyContent(navController: NavHostController) {
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
                .clickable { navController.navigate("history") }
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
    val navController = rememberNavController()

    val bottomNavigationItems = listOf(
        BottomNavItem.Home,
        BottomNavItem.Barber,
        BottomNavItem.Booking,
        BottomNavItem.History,
        BottomNavItem.Profile
    )

    Scaffold(
        bottomBar = {
            SppokyAppBottomNavigation(navController, bottomNavigationItems)
        },
        topBar = {
            CustomTopBar()
        }
    ) {
        innerPadding -> Column(modifier = Modifier.padding(innerPadding)) {
        BodyContent(navController)
        }
        MainScreenNavigationConfigurations(navController, Modifier.padding(innerPadding))
    }
}

@Composable
private fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}

@Composable
private fun MainScreenNavigationConfigurations(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(navController, startDestination = BottomNavItem.Home.route,
        modifier = modifier) {
        composable(BottomNavItem.Home.route) {
//            UserHomeScreen()
        }
        composable(BottomNavItem.Barber.route) {
        }
        composable(BottomNavItem.Booking.route) {
        }
        composable(BottomNavItem.History.route) {
        }
        composable(BottomNavItem.Profile.route) {
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserHomePreview() {
    UserHomeScreen()
}
