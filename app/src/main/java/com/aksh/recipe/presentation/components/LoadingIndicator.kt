package com.aksh.recipe.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.aksh.recipe.ui.theme.orange

@Composable
fun LoadingIndicator(strokeWidth: Dp) {

    Box(modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center)
    {
        CircularProgressIndicator(
            color = orange,
            strokeWidth = strokeWidth
        )
    }

}