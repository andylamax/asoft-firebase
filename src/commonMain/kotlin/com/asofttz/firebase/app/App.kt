package com.asofttz.firebase.app

import com.asofttz.firebase.auth.Auth
import com.asofttz.firebase.firestore.Firestore
import com.asofttz.firebase.storage.Storage

expect interface App {
    val name: String
    val options: Options
    fun firestore(): Firestore
    fun auth(): Auth
    fun storage() : Storage
}

class Options(
        var apiKey: String = "",
        var authDomain: String = "",
        var databaseURL: String = "",
        var projectId: String = "",
        var storageBucket: String = "",
        var messagingSenderId: String = "",
        var appId: String = ""
)