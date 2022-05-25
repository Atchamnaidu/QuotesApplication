package com.example.quotesapp

import com.example.quotesapp.model.QuotesData
import com.example.quotesapp.model.Response
import com.example.quotesapp.repository.QuotesRepository

class FakeQuotesRepository : QuotesRepository {
    override suspend fun getQuotes(): Response<List<QuotesData>> {
        return Response.Success(getStubQuotes())
    }

    private fun getStubQuotes(): List<QuotesData> {
        return listOf(
            QuotesData(
                "Walter White",
                "I am not in danger, Skyler. I am the danger!",
                1,
                "Breaking Bad"
            ),
            QuotesData(
                "Walter White",
                "I am not in danger, Skyler. I am the danger!",
                2,
                "Breaking Bad"
            )
        )

    }
}