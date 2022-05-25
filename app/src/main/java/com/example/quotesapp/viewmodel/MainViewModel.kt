package com.example.quotesapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quotesapp.model.QuotesData
import com.example.quotesapp.model.Response
import com.example.quotesapp.repository.QuotesRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val quotesRepository: QuotesRepository,
) :
    ViewModel() {
    private val _quotes = MutableLiveData<Response<List<QuotesData>>>()
    val quotes: LiveData<Response<List<QuotesData>>>
        get() = _quotes

    fun getQuotes() {
        viewModelScope.launch {
            val quotesData = quotesRepository.getQuotes()
            _quotes.value = quotesData

            //Read from room db offline : add quotesDatabase in constructor
//            quotesDatabase.getQuotesDao().getQuotes().observeForever { quotesList ->
//            _quotes.value = Response.Success(quotesList)}
        }
    }
}
