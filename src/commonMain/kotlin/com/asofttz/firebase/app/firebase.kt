package com.asofttz.firebase.app

expect object firebase {
    fun initializeApp(options: Options, name: String? = null) : App
}