package com.example.retrofitapi.fox

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FoxRepository {
    private val foxService: FoxService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://randomfox.ca/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        foxService = retrofit.create(FoxService::class.java)
    }

    fun getRandomFox(): Fox = foxService.getRandomFox()
}