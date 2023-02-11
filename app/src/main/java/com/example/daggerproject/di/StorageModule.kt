package com.example.daggerproject.di

import com.example.daggerproject.DatabaseHelper
import dagger.Module
import dagger.Provides

@Module
class StorageModule {

    @Provides
    fun provideDatabaseHelper(): DatabaseHelper = DatabaseHelper()

}
