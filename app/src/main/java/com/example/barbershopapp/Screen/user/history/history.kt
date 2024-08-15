package com.example.barbershopapp.Screen.user.history

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.barbershopapp.R
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.*



@Composable
fun RatingBar(
    modifier: Modifier = Modifier,
    rating : Int,
    onRatingChanged :  (Int) -> Unit
) {
    Row(modifier = modifier){
        for (i in 1..5){
            val iconInt = if (i <= rating) Color.Yellow else Color.Gray
            Icon(
                painter = painterResource(id = R.drawable.img_2),
                contentDescription = "Star $i",
                tint = iconInt,
                modifier = Modifier
                    .size(24.dp)
                    .clickable { onRatingChanged(i) }
            )
        }
    }
}

@Composable
fun historyScreen(){
    var rating by remember {
        mutableIntStateOf(0)
    }
    Spacer(modifier = Modifier.height(16.dp))
    RatingBar(
        rating = rating,
        onRatingChanged = { newRating -> rating = newRating },
        modifier = Modifier.fillMaxWidth()
    )
}

@Preview(showBackground = true)
@Composable
fun historyPreview(){
    historyScreen()
}