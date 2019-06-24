package com.asofttz.firebase.core

import com.asofttz.firebase.firestore.document.Object

actual class FirebaseOptions {
    var apiKey = ""
    var authDomain = ""
    var databaseURL = ""
    var projectId = ""
    var storageBucket = ""
    var messagingSenderId = ""
    var appId = ""
}

actual var FirebaseOptions.apiKey: String
    get() = apiKey
    set(value) {
        apiKey = value
    }

actual var FirebaseOptions.authDomain: String
    get() = authDomain
    set(value) {
        authDomain = value
    }

actual var FirebaseOptions.databaseUrl: String
    get() = databaseURL
    set(value) {
        databaseURL = value
    }

actual var FirebaseOptions.projectId: String
    get() = projectId
    set(value) {
        projectId = value
    }

actual var FirebaseOptions.storageBucket: String
    get() = storageBucket
    set(value) {
        storageBucket = value
    }

actual var FirebaseOptions.messagingSenderId: String
    get() = messagingSenderId
    set(value) {
        messagingSenderId = value
    }

actual var FirebaseOptions.appId: String
    get() = appId
    set(value) {
        appId = value
    }


actual class FirebaseOptionsBuilder {
    var apiKey = ""
    var authDomain = ""
    var databaseURL = ""
    var projectId = ""
    var storageBucket = ""
    var messagingSenderId = ""
    var appId = ""
}

actual var FirebaseOptionsBuilder.apiKey: String
    get() = apiKey
    set(value) {
        apiKey = value
    }

actual var FirebaseOptionsBuilder.authDomain: String
    get() = authDomain
    set(value) {
        authDomain = value
    }

actual var FirebaseOptionsBuilder.databaseUrl: String
    get() = databaseURL
    set(value) {
        databaseURL = value
    }

actual var FirebaseOptionsBuilder.projectId: String
    get() = projectId
    set(value) {
        projectId = value
    }

actual var FirebaseOptionsBuilder.storageBucket: String
    get() = storageBucket
    set(value) {
        storageBucket = value
    }

actual var FirebaseOptionsBuilder.messagingSenderId: String
    get() = messagingSenderId
    set(value) {
        messagingSenderId = value
    }

actual var FirebaseOptionsBuilder.appId: String
    get() = appId
    set(value) {
        appId = value
    }

actual fun FirebaseOptionsBuilder.build(): FirebaseOptions = Object.assign(FirebaseOptions(), this)