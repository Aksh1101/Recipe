package com.aksh.recipe.data.remote

import com.aksh.recipe.data.remote.dto.AddRecipeRequest
import com.aksh.recipe.data.remote.dto.Recipe
import com.aksh.recipe.data.remote.dto.RecipeResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType

class ApiService(private val client: HttpClient) {

    suspend fun getAllRecipe() : RecipeResponse{
        return client.get(urlString = "${KtorClient.BASE_URL}recipes").body()
    }

    suspend fun getRecipeById(id : Int) : Recipe {
        return client.get(urlString = "${KtorClient.BASE_URL}recipes/$id ").body()
    }

    suspend fun addRecipe(request : AddRecipeRequest) {
        client.post(urlString = "${KtorClient.BASE_URL}recipes/add"){
            contentType(ContentType.Application.Json)
            setBody(request)
        }
    }

}