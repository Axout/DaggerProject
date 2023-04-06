package com.example.daggerproject.di

import com.example.daggerproject.DatabaseHelper
import com.example.daggerproject.MainActivityPresenter
import com.example.daggerproject.NetworkUtils
import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @Provides
    fun provideMainActivityPresenter(databaseHelper: DatabaseHelper, networkUtils: NetworkUtils): MainActivityPresenter {
        return MainActivityPresenter(databaseHelper, networkUtils)
    }
}