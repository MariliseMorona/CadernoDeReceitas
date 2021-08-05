package com.example.cadernodereceitas.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL="https://www.themealdb.com/api/json/v1/1/"

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

object CategoriesService{
    val service: TheFoodRecipesApi by lazy {
        retrofit.create(TheFoodRecipesApi::class.java)
    }
}