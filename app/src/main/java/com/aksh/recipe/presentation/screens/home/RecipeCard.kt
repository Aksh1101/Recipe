package com.aksh.recipe.presentation.screens.home

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.SubcomposeAsyncImage
import com.aksh.recipe.data.remote.dto.Recipe
import com.aksh.recipe.presentation.components.LoadingIndicator
import com.aksh.recipe.ui.theme.orange

@Composable
fun RecipeCard(
    recipe : Recipe,
    onClick : () -> Unit
) {


    Card(modifier = Modifier.fillMaxWidth()
        .clickable(onClick = onClick),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        border = CardDefaults.outlinedCardBorder()
    )
    {
        Column()
        {
            SubcomposeAsyncImage(
                model = recipe.image,
                contentDescription = recipe.name,
                modifier = Modifier.fillMaxWidth().height(140.dp)
                    .clip(shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
                contentScale = ContentScale.Crop,
                loading = { LoadingIndicator(strokeWidth = 2.dp) },
                error = {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ){
                        Text(
                            text = "❌",
                            fontSize = 32.sp
                        )
                    }
                }
            )
            Column(modifier = Modifier.padding(12.dp))
            {
                 Text(
                     text = recipe.name,
                     fontSize = 16.sp,
                     fontWeight = FontWeight.Bold,
                     maxLines = 1,
                     overflow = TextOverflow.Ellipsis,
                     color = Color.DarkGray
                 )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = recipe.cuisine,
                        color = Color.Gray,
                        fontSize = 12.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.weight(1f)
                    )

                    Box(
                        modifier = Modifier.background(
                            color = orange.copy(0.1f),
                            shape = RoundedCornerShape(8.dp)
                        )
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    ){
                        Text(
                            text = recipe.difficulty,
                            fontSize = 12.sp,
                            color = orange,
                            fontWeight = FontWeight.SemiBold
                        )

                    }
                }
            }

        }
    }

}