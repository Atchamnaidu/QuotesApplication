package com.example.quotesapp.di.module

import android.content.Context
import com.example.quotesapp.QuotesApplication
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class AppModule {
    @Singleton
    @Binds
    abstract fun provideContext(application: QuotesApplication): Context
}