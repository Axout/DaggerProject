package com.example.daggerproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity: AppCompatActivity() {

    lateinit var mainActivityPresenter: MainActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * Получаем от компонента фабрику и создаем сабкомпонент
         */
        val mainComponent = (application as App).appComponent.getMainComponentFactory().create(this)

        mainActivityPresenter = mainComponent.getMainActivityPresenter()

    }
}
