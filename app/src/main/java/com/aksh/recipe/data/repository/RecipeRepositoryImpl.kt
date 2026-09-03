package com.aksh.recipe.data.repository

import com.aksh.recipe.data.remote.ApiService
import com.aksh.recipe.data.remote.dto.Recipe
import com.aksh.recipe.domain.repository.RecipeRepository

class RecipeRepositoryImpl(private val apiService: ApiService): RecipeRepository{

    override suspend fun getAllRecipes(): List<Recipe> {
        return apiService.getAllRecipe().recipes
    }


    override suspend fun getRecipeById(id: Int): Recipe {
        return apiService.getRecipeById(id)
    }
}