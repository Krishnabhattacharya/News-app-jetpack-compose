package com.example.newsapp.repository

import com.example.newsapp.model.NewsModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiServices{
    @GET("latest")
    suspend fun getNews(
        @Query("apikey")apiKey:String,
        @Query("q")query:String
    ):Response<NewsModel>
}