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

class HomeViewModel : ViewModel() {

    private val repository : RecipeRepository = RecipeRepositoryImpl(
        apiService = ApiService(client = KtorClient.client)
    )

    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    var recipes by mutableStateOf<List<Recipe>>(emptyList())
        private set

    var categories by mutableStateOf<List<String>>(listOf("All"))
        private set

    var selectedCategory by mutableStateOf("All")
        private set

    private var allRecipe : List<Recipe> = emptyList()

    init {
        fetchRecipes()
    }

    fun fetchRecipes(){

        isLoading = true
        errorMessage = null

        viewModelScope.launch {

            try {
                val result = repository.getAllRecipes()
                allRecipe = result

                val cuisines = result.map { it.cuisine }.distinct().sorted()
                categories = listOf("All") + cuisines

                applyFilters()
            }catch (e: Exception){
                errorMessage = e.message ?: " An expected error occurred  "
            }finally {
                isLoading = false
            }


        }
    }

    fun onCategorySelected(category : String){
        selectedCategory = category
        applyFilters()

    }

    private fun applyFilters(){
        recipes = if (selectedCategory == "All") allRecipe
        else allRecipe.filter { it.cuisine == selectedCategory }
    }
}