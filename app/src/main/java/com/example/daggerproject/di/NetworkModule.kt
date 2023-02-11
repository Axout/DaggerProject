package com.example.daggerproject.di

import com.example.daggerproject.ConnectionManager
import com.example.daggerproject.NetworkUtils
import dagger.Module
import dagger.Provides

@Module
class NetworkModule {

    @Provides
    fun provideNetworkUtils(connectionManager: ConnectionManager): NetworkUtils =
        NetworkUtils(connectionManager)

    @Provides
    fun provideConnectionManager(): ConnectionManager = ConnectionManager()

}
