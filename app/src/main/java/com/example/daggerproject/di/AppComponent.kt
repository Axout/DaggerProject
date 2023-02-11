package com.example.daggerproject.di

import com.example.daggerproject.DatabaseHelper
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
@Component (modules = [StorageModule::class, NetworkModule::class])
interface AppComponent {

    fun getDatabaseHelper(): DatabaseHelper
    fun getNetworkUtils(): NetworkUtils
}
