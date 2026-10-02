package com.aksh.recipe.presentation.screens.recipe_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aksh.recipe.presentation.components.ErrorMessage
import com.aksh.recipe.presentation.components.LoadingIndicator
import com.aksh.recipe.presentation.components.RecipeTopbar
import com.aksh.recipe.presentation.viewmodels.RecipeDetailViewModel
import com.aksh.recipe.ui.theme.orange

@Composable
fun RecipeDetailScreen(
    recipeId: Int,
    onBack: () -> Unit,
    viewModel: RecipeDetailViewModel = viewModel()
) {
    LaunchedEffect(recipeId) {
        viewModel.fetchRecipeDetails(recipeId)
    }

    Scaffold(
        topBar = {
            RecipeTopbar(
                title = "Recipe Details",
                onBackClick = onBack,
                icon = Icons.AutoMirrored.Filled.ArrowBack
            )
        }
    ) { innerPadding ->

        Box(modifier = Modifier.fillMaxSize()
            .padding(innerPadding)
            .background(color = orange.copy(0.05f)))
        {
            when{
                viewModel.isLoading -> LoadingIndicator(strokeWidth = 1.dp)

                viewModel.errorMessage != null -> ErrorMessage(
                    errorMessage = viewModel.errorMessage,
                    onRetry = { viewModel.fetchRecipeDetails(recipeId) }
                )

                viewModel.recipe != null -> {
                    RecipeDetailContent(details = viewModel.recipe!!)

                }
            }
        }
    }
}