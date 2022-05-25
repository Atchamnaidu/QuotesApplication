package com.example.quotesapp.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "quotes")
data class QuotesData(
    val author: String,
    val quote: String,
    @PrimaryKey
    @SerializedName("quote_id")
    val quoteId: Int,
    val series: String
)