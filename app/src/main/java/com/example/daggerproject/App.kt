package com.example.daggerproject

import android.app.Application
import com.example.daggerproject.di.AppComponent
import com.example.daggerproject.di.DaggerAppComponent

class App: Application() {

    /**
     * Метод builder() теперь возвращает наш кастомный билдер.
     * И мы вызываем у него метод buildAppComp, чтобы получить компонент.
     */
    val appComponent: AppComponent = DaggerAppComponent.create()
}
