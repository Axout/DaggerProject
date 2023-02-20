package com.example.daggerproject.di

import com.example.daggerproject.Repository
import dagger.Module
import dagger.Provides

@Module
class StorageModule {

    @Provides
    fun provideRepository(): Repository {
        return Repository()
    }

}
