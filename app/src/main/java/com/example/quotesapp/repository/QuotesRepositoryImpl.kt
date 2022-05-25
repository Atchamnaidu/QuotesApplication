package com.example.quotesapp.repository

import com.example.quotesapp.model.QuotesData
import com.example.quotesapp.model.Response
import com.example.quotesapp.network.ApiServices
import com.example.quotesapp.room.QuotesDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class QuotesRepositoryImpl @Inject constructor(
    private val apiServices: ApiServices,
    private val quotesDatabase: QuotesDatabase
) : QuotesRepository {
    override suspend fun getQuotes(): Response<List<QuotesData>> = withContext(Dispatchers.IO) {
        val response = apiServices.getQuotes()
        if (response.isSuccessful && response.body() != null) {
            quotesDatabase.getQuotesDao().insertQuotes(response.body()!!)
            Response.Success(response.body())
        } else {
            Response.Error(errorMsg = response.errorBody().toString())
        }
    }
}