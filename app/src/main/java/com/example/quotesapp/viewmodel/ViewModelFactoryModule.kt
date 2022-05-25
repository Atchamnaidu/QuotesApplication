package com.example.quotesapp.viewmodel

import androidx.lifecycle.ViewModelProvider
import com.example.quotesapp.di.ViewModelFactory
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class ViewModelFactoryModule {
    @Singleton
    @Binds
    abstract fun providesViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}