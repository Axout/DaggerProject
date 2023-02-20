package com.example.daggerproject

import javax.inject.Inject

class NetworkUtils @Inject constructor(private val connectionManager: ConnectionManager) {
}
