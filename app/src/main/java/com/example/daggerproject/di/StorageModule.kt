package com.example.daggerproject.di

import com.example.daggerproject.DatabaseHelper
import com.example.daggerproject.Repository
import dagger.Module
import dagger.Provides

@Module
class StorageModule {

    @Provides
    fun provideDatabaseHelper(repository: Repository): DatabaseHelper =
        DatabaseHelper(repository)

    @Provides
    fun provideRepository(): Repository {
        return Repository()
    }

}
