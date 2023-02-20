package com.example.daggerproject

import javax.inject.Inject

class MainActivityPresenter @Inject constructor(
    private val databaseHelper: DatabaseHelper,
    private val networkUtils: NetworkUtils,
) {
}
