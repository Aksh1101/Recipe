package com.aksh.recipe.presentation.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.aksh.recipe.ui.theme.orange

@Composable
fun CategorySection(
    categories : List<String>,
    selected: String,
    onSelected : (String) -> Unit
) {
    Column() {

        SectionHeader(
            title = "Categories",
            icon = Icons.Default.Restaurant
        )

        Spacer(modifier = Modifier.height(8.dp))

        LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp))
        {
            items(categories){category->

                var isSelected = selected == category

                FilterChip(
                    selected = isSelected,
                    onClick = {onSelected(category)},
                    label = {
                        Text(
                            text = category,
                            fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal
                        )
                    },
                    shape = CircleShape,
                    colors = FilterChipDefaults.filterChipColors(
                        selectedLabelColor = Color.White,
                        selectedContainerColor = orange,
                        labelColor = Color.DarkGray,
                        containerColor = Color.White
                    )
                )
            }
        }
    }




}