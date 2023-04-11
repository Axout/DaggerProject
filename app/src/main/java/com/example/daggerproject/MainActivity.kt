package com.example.daggerproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.daggerproject.di.MainComponent
import javax.inject.Inject

class MainActivity: AppCompatActivity() {

    /**
     * В Activity добавляем поле с типом MainComponent.Builder и помечаем его аннотацией Inject.
     *
     * Есть ли разница между get и inject вариантами получения билдера сабкомпонента?
     * Официальная документация говорит нам следующее:
     *
     * Using @Module.subcomponents is better since it allows Dagger to detect if the subcomponent is ever requested. Installing a subcomponent via a method on the parent component is an explicit request for that component, even if that method is never called. Dagger can’t detect that, and thus must generate the subcomponent even if you never use it.
     */
    @Inject
    lateinit var mainComponentBuilder: MainComponent.Builder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * Вызываем injectMainActivity метод у компонента,
         * он поместит билдер в переменную mainComponentBuilder,
         * и мы сможем его билдер использовать для построения сабкомпонента.
         */
        (application as App).appComponent.injectMainActivity(this)

        val mainComponent = mainComponentBuilder.activity(this).build()

    }
}
