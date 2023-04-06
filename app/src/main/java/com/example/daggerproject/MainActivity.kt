package com.example.daggerproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity: AppCompatActivity() {

    lateinit var mainActivityPresenter: MainActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * Мы получаем от компонента билдер и сами создаем сабкомпонент MainComponent.
         * При этом мы передаем туда все, что нужно сабкомпоненту для создания объектов.
         * В нашем случае это activity.
         */
        val mainComponent = (application as App).appComponent.getMainComponentBuilder()
            .activity(this)
            .build()

        mainActivityPresenter = mainComponent.getMainActivityPresenter()

    }
}
