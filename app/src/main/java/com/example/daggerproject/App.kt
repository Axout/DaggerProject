package com.example.daggerproject

import android.app.Application
import com.example.daggerproject.di.AppComponent
import com.example.daggerproject.di.DaggerAppComponent
import com.example.daggerproject.di.NetworkModule

class App: Application() {

    /**
     * Метод builder() теперь возвращает наш кастомный билдер.
     * И мы вызываем у него метод buildAppComp, чтобы получить компонент.
     */
    val appComponent: AppComponent = DaggerAppComponent
        .builder()
        /*
         * Соответственно и создавать объект AppModule нам самим больше не надо.
         * Билдер сам это сделает, конструктор теперь пустой.
         *
         * ! В документации указано, что этот способ является более предпочтительным,
         * чем передача через конструктор модуля.
         */
        .networkModule(NetworkModule())
        .context(this)
        .buildAppComp()
}
