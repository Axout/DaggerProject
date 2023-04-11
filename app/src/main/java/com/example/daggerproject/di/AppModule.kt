package com.example.daggerproject.di

import android.content.Context
import android.content.res.Resources
import dagger.Module
import dagger.Provides

/**
 * Чтобы связать AppComponent и MainComponent нужно в модуле, который используется в AppComponent,
 * в параметре subcomponents прописать MainComponent:
 */
@Module(subcomponents = [MainComponent::class])
class AppModule {

    @Provides
    fun getResources(context: Context): Resources {
        return context.resources
    }

    /**
     * До этого Context не был встроен в граф объектов компонента.
     * Т.е. даггер не смог бы предоставить нам этот объект, если бы мы попросили.
     * Или он не смог бы использовать Context при создании объектов вне модуля AppModule.
     * Чтобы это исправить, мы можем завернуть этот объект в отдельный Provides метод.
     *
     * Теперь даггер сможет оперировать Context-ом.
     * Он сможет его использовать для создания других объектов, даже если они создаются в других модулях.
     */
    @Provides
    fun getAppContext(context: Context): Context {
        return context
    }
}