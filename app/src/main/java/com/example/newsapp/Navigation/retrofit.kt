package com.example.newsapp.repository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NewsRetrofit {
    private const val baseUrl = "https://newsdata.io/api/1/"

    val ApiServices: NewsApiServices by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create()) // Add this
            .build()
            .create(NewsApiServices::class.java)
    }
}