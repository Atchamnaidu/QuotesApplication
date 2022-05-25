package com.example.quotesapp.network

import com.example.quotesapp.model.QuotesData
import retrofit2.Response
import retrofit2.http.GET

interface ApiServices {
    @GET("quotes")
    suspend fun getQuotes(): Response<List<QuotesData>>
}