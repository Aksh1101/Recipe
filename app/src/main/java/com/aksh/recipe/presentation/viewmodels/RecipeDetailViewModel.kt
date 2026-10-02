package com.aksh.recipe.presentation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aksh.recipe.data.remote.ApiService
import com.aksh.recipe.data.remote.KtorClient
import com.aksh.recipe.data.remote.dto.Recipe
import com.aksh.recipe.data.repository.RecipeRepositoryImpl
import com.aksh.recipe.domain.repository.RecipeRepository
import kotlinx.coroutines.launch

class RecipeDetailViewModel : ViewModel()  {

    private val repository : RecipeRepository = RecipeRepositoryImpl(
        apiService = ApiService(KtorClient.client)
    )

    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    var recipe by mutableStateOf<Recipe?>(null)
        private set

    fun fetchRecipeDetails(recipeId : Int){
        isLoading = true
        errorMessage = null

        try {
            viewModelScope.launch {
                recipe = repository.getRecipeById(recipeId)
            }
        }catch (e : Exception){
            errorMessage = e.message ?: "An unexpected error occurred"
        }finally {
            isLoading = false
        }


    }
}