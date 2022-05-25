package com.example.quotesapp.di.module

import com.example.quotesapp.network.ApiServices
import com.example.quotesapp.repository.QuotesRepository
import com.example.quotesapp.repository.QuotesRepositoryImpl
import com.example.quotesapp.room.QuotesDatabase
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun providesQuotesRepository(
        apiServices: ApiServices,
        database: QuotesDatabase
    ): QuotesRepository = QuotesRepositoryImpl(apiServices, database)
}