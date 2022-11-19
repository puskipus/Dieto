package com.example.dieto.Api

import com.example.dieto.RecipeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {
    @Headers(
        "X-RapidAPI-Key: 54f824b771msha1a92b9020af6a1p113052jsn17753c2a72ac",
        "X-RapidAPI-Host: edamam-recipe-search.p.rapidapi.com"
    )
    @GET("search")
    fun getRecipe(
        @Query("q") query : String,
    ): Call<RecipeResponse>
}