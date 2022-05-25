package com.example.quotesapp.di.module

import com.example.quotesapp.view.MainActivity
import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.ContributesAndroidInjector

@Module(includes = [AndroidInjectionModule::class])
abstract class ActivityModuleFactory {
    @ContributesAndroidInjector(modules = [MainViewModelModule::class, RepositoryModule::class])
    abstract fun providesMainActivity(): MainActivity
}