package com.example.daggerproject

import android.app.Application
import com.example.daggerproject.di.AppComponent
import com.example.daggerproject.di.AppModule
import com.example.daggerproject.di.DaggerAppComponent

class App: Application() {

    val appComponent: AppComponent = DaggerAppComponent
        .builder()
        .appModule(AppModule(this))
        .build()
}
