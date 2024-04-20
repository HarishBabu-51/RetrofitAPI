package com.example.retrofitapi

import retrofit2.http.GET

interface FoxService {
    @GET("floof/")
    suspend fun getRandomFox(): Fox
}