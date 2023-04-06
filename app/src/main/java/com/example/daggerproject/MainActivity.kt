package com.example.daggerproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity: AppCompatActivity() {

    lateinit var mainActivityPresenter: MainActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * Теперь в MainActivity мы можем получить MainComponent из AppComponent.
         * А из MainComponent можем получить презентер:
         */
        val mainComponent = (application as App).appComponent.getMainComponent()

        mainActivityPresenter = mainComponent.getMainActivityPresenter()

    }
}
