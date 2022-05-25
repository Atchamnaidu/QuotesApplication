package com.example.quotesapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.quotesapp.viewmodel.MainViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {
    lateinit var viewModel: MainViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @Before
    fun setup() {
        viewModel = MainViewModel(FakeQuotesRepository())
    }

    @Test
    fun test_quotes_received() {
        viewModel.getQuotes()
        val value = viewModel.quotes.getOrAwaitValueTest()

        Assert.assertTrue(value.data?.size == 2)
    }


}