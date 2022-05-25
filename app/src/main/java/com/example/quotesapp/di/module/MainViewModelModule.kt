package com.example.quotesapp.di.module

import androidx.lifecycle.ViewModel
import com.example.quotesapp.di.ViewModelKey
import com.example.quotesapp.viewmodel.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
abstract class MainViewModelModule {
    @Binds
    @IntoMap
    @ClassKey(MainViewModel::class)
    abstract fun providesMainViewModel(mainViewModel: MainViewModel): ViewModel
}