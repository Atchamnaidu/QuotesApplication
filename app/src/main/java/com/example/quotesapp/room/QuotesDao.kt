package com.example.quotesapp.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.quotesapp.model.QuotesData

@Dao
interface QuotesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuotes(quotes: List<QuotesData>)

    @Query("SELECT * FROM quotes")
    fun getQuotes(): LiveData<List<QuotesData>>
}