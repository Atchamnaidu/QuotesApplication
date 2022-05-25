package com.example.quotesapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.quotesapp.model.QuotesData

@Database(entities = [QuotesData::class], version = 1)
abstract class QuotesDatabase : RoomDatabase() {
    abstract fun getQuotesDao() : QuotesDao
}