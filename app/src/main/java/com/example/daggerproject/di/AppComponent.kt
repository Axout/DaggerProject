package com.example.daggerproject.di

import android.content.Context
import com.example.daggerproject.MainActivityPresenter
import dagger.BindsInstance
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
@Component (modules = [AppModule::class, StorageModule::class, NetworkModule::class])
interface AppComponent {

    /**
     * С версии 2.22 в даггере появился еще один способ создать компонент.
     * Вместо билдера с несколькими методами, мы можем использовать один метод с несколькими аргументами.
     * Для этого используется Factory.
     *
     * Внутри компонента нам надо создать интерфейс с аннотацией @Component.Factory.
     * Имя интерфейса может быть любым. А метод будет только один.
     * Он должен принимать на вход все @BindsInstance объекты и модули, которые нужны компоненту.
     * А на выходе он должен возвращать компонент. Т.е. получается билдер, упакованный в один метод.
     */
    @Component.Factory
    interface AppCompFactory {
        fun create(@BindsInstance context: Context, networkModule: NetworkModule): AppComponent
    }

    /**
     * Мы можем научить компонент не возвращать объекты, а самому наполнять Activity требуемыми объектами.
     * Т.е. мы даем компоненту экземпляр MainActivity, а он смотрит, какие объекты нужны,
     * создает их и сам помещает в соответствующие поля.
     */
    fun getMainActivityPresenter(): MainActivityPresenter
}
