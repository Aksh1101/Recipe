package com.aksh.recipe.presentation.navigation

import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer

@Serializable
object HomeRoute

@Serializable
data class RecipeDetailRoute(val recipeId: Int)