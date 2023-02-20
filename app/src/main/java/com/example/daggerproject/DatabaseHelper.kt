package com.example.daggerproject

import javax.inject.Inject

class DatabaseHelper @Inject constructor(private val repository: Repository) {
}
