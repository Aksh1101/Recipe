package com.aksh.recipe.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aksh.recipe.presentation.viewmodels.RecipeDetailViewModel
import com.aksh.recipe.ui.theme.orange

@Composable
fun ErrorMessage(
    errorMessage : String?,
    onRetry : () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()
        .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center)
    {
        Text(
            errorMessage ?: "",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = orange,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = { onRetry },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                contentColor = orange,
                containerColor = Color.White
            ))
        {
            Text(
                "Retry",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }


}