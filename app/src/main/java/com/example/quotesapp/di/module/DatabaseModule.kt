package com.example.quotesapp.di.module

import android.content.Context
import androidx.room.Room
import com.example.quotesapp.room.QuotesDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideQuoteDatabase(context: Context): QuotesDatabase {
        return Room.databaseBuilder(context, QuotesDatabase::class.java, "QuotesDB").build()
    }
}