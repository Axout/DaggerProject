package com.example.daggerproject.di

import com.example.daggerproject.ConnectionManager
import dagger.Module
import dagger.Provides

@Module
class NetworkModule {

    @Provides
    fun provideConnectionManager(): ConnectionManager = ConnectionManager()

}
