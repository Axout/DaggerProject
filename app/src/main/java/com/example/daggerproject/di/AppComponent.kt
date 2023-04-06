package com.example.daggerproject.di

import com.example.daggerproject.DatabaseHelper
import com.example.daggerproject.MainActivityPresenter
import com.example.daggerproject.NetworkUtils
import dagger.Component

/**
 * Ошибки
 * Иногда даггер показывает ошибки, даже если все сделано правильно.
 * Проблема обычно в кэшировании. Он себе там что-то закешировал и не подтягивает новые изменения.
 * В этом случае есть пара действий, которые могут помочь:
 * 1) Build -> Clean project
 * 2) File -> Invalidate cache and restart -> Invalidate and restart
 *
 * Но иногда не помогает даже это. Тогда попробуйте переименовать объект, на который даггер ругается.
 * Просто поменяйте одну букву в имени с помощью SHIFT+F6. И попробуйте запустить проект.
 * Если все ок, то возвращайте имя обратно, ошибка не должна вернуться.
 * Ну а если ничего из этого не помогает,
 * то возможно все таки что-то сделано неправильно и даггер ругается не просто так.
 */
@Component (modules = [StorageModule::class, NetworkModule::class, MainModule::class])
interface AppComponent {
    fun getDatabaseHelper(): DatabaseHelper
    fun getNetworkUtils(): NetworkUtils

    /**
     * Все вроде в порядке, но что если нам нужен не только презентер,
     * но и еще какие-то объекты, специфичные для MainActivity и его дочерних фрагментов.
     * В этом случае в AppComponent нам надо будет описывать несколько getMain* или injectMain* методов.
     * А потом будут добавляться еще Activity и для них тоже надо будет создавать методы.
     * В итоге AppComponent превратится в монстра, который умеет и знает все.
     *
     * Чтобы AppComponent не стал таким, мы можем создать для него сабкомпонент MainComponent.
     * Туда мы вынесем все, что касается MainActivity.
     */
    fun getMainActivityPresenter(): MainActivityPresenter
}
