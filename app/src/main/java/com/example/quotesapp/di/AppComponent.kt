package com.example.quotesapp.di

import com.example.quotesapp.QuotesApplication
import com.example.quotesapp.di.module.ActivityModuleFactory
import com.example.quotesapp.di.module.AppModule
import com.example.quotesapp.di.module.DatabaseModule
import com.example.quotesapp.di.module.NetworkModule
import com.example.quotesapp.viewmodel.ViewModelFactoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidInjectionModule::class,
        AppModule::class,
        NetworkModule::class,
        ViewModelFactoryModule::class,
        ActivityModuleFactory::class,
        DatabaseModule::class
    ]
)
interface AppComponent : AndroidInjector<QuotesApplication> {

    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        @BindsInstance
        fun application(application: QuotesApplication): Builder
    }
}