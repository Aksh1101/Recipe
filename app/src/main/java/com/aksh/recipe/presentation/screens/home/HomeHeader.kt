package com.aksh.recipe.presentation.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.RestaurantMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aksh.recipe.ui.theme.orange

@Composable
fun HomeHeader() {

    Row(modifier = Modifier.fillMaxWidth()
        .clip(RoundedCornerShape(20.dp))
        .background(color = orange.copy(0.1f))
        .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    )
    {
        Box(
            modifier = Modifier.size(48.dp)
                .background(
                    color = orange,
                    shape = RoundedCornerShape(16.dp)
                ),
            contentAlignment = Alignment.Center
        )
        {
            Icon(Icons.Default.RestaurantMenu,
                "MenuIcon",
                tint = Color.White)
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column()
        {
            Text("Hello Chef",
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(2.dp))

            Text("Find something delicious to cook ",
                color = Color.Gray)
        }
    }

}