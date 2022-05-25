package com.example.quotesapp.repository

import com.example.quotesapp.model.QuotesData
import com.example.quotesapp.model.Response

interface QuotesRepository {
    suspend fun getQuotes(): Response<List<QuotesData>>
}