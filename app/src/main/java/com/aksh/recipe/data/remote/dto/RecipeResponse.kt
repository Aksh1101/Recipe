package com.aksh.recipe.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class RecipeResponse(
    val limit: Int,
    val recipes: List<Recipe>,
    val skip: Int,
    val total: Int
)