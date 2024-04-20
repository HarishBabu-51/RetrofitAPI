package com.example.retrofitapi.fox

import retrofit2.http.GET

interface FoxService {
    @GET("floof/")
    fun getRandomFox(): Fox
}