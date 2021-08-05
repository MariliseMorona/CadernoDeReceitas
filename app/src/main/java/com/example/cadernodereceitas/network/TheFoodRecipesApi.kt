package com.example.cadernodereceitas.network

import com.example.cadernodereceitas.entities.ListCategoryRemote
import retrofit2.http.GET

interface TheFoodRecipesApi {
    @GET("categories.php")
    suspend fun getCategories(): ListCategoryRemote

}