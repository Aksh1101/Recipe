package com.aksh.recipe.domain.repository

import com.aksh.recipe.data.remote.dto.Recipe

interface RecipeRepository {

    suspend fun getAllRecipes() : List<Recipe>

    suspend fun getRecipeById(id : Int) : Recipe
}