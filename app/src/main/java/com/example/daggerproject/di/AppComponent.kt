package com.example.daggerproject.di

import android.app.Activity
import com.example.daggerproject.MainActivity
import com.example.daggerproject.MainActivityPresenter
import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent

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
@Component(modules = [AppModule::class, StorageModule::class, NetworkModule::class])
interface AppComponent {
    /**
     * Чтобы заинджектить билдер сабкомпонента в Activity, мы в компоненте описываем inject метод.
     * Мы передаем этому методу экземпляр Activity, и метод инджектит необходимые объекты в этот экземпляр.
     */
    fun injectMainActivity(activity: MainActivity)
}

/**
 * Преимущества Subcomponent.
 *
 * Во-первых - это логическое разделение функционала. Вместо одного компонента, который умеет и знает все,
 * мы создаем разные компоненты, ответственные за свои области.
 *
 * Во-вторых - это более гибкая передача объектов в компоненты.
 *
 * В-третьих - это более гибкое время жизни объектов, возвращаемых компонентами.
 *
 * Сабкомпонент - это не какая-то часть компонента. Это скорее похоже на расширение компонента.
 * У сабкомпонента MainComponent есть свои объекты, которые он умеет создавать (MainActivityPresenter).
 * Но при этом он сможет создать (или использовать для создания своих объектов) любой объект,
 * доступный в AppComponent.
 *
 * А вот AppComponent ничего не знает про MainActivityPresenter и создать его не сможет.
 *
 * Интерфейс для сабкомпонента создается точно так же, как и для компонента,
 * только аннотация используется другая - @Subcomponent.
 *
 * Еще важный момент. Заметьте, что в сабкомпоненте MainComponent мы нигде и никак не указывали
 * какой именно компонент будет создателем (родителем) этого сабкомпонента. Это может быть AppComponent.
 * А может быть и любой другой компонент. Главное, чтобы он предоставил сабкомпоненту необходимые объекты.
 */
@Subcomponent(modules = [MainModule::class])
interface MainComponent {

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        fun activity(activity: Activity): Builder
        fun build(): MainComponent
    }

    fun getMainActivityPresenter(): MainActivityPresenter
}
