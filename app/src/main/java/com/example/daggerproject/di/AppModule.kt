package com.example.daggerproject.di

import android.content.Context
import android.content.res.Resources
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val context: Context) {

    @Provides
    fun getResources(): Resources {
        return context.resources
    }
}