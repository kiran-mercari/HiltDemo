package com.example.hiltdemo

import javax.inject.Inject

class Welcome @Inject constructor() {
    fun printWelcome() {
        println("Hi Welcome to Hilt Demo")
    }
}
