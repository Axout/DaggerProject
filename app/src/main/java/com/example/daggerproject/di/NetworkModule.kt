package com.example.daggerproject.di

import com.example.daggerproject.NetworkUtils
import dagger.Module
import dagger.Provides

@Module
class NetworkModule {

    @Provides
    fun provideNetworkUtils(): NetworkUtils = NetworkUtils()

}
