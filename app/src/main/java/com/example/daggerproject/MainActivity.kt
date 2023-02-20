package com.example.daggerproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import javax.inject.Inject

class MainActivity @Inject constructor(
    private val databaseHelper: DatabaseHelper,
    private val networkUtils: NetworkUtils,
): AppCompatActivity() {

    lateinit var mainActivityPresenter: MainActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityPresenter = (application as App).appComponent.getMainActivityPresenter()

    }
}
