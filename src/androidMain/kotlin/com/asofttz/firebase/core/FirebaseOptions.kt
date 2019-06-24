package com.asofttz.firebase.core

actual typealias FirebaseOptions = com.google.firebase.FirebaseOptions

actual var FirebaseOptions.apiKey: String
    set(value) {
        throw Throwable("Use FirebaseOptionsBuilder")
    }
    get() = apiKey

actual var FirebaseOptions.authDomain: String
    set(value) {
        throw Throwable("Use FirebaseOptionsBuilder")
    }
    get() = ""

actual var FirebaseOptions.databaseUrl: String
    set(value) {
        throw Throwable("Use FirebaseOptionsBuilder")
    }
    get() = databaseUrl

actual var FirebaseOptions.projectId: String
    set(value) {
        throw Throwable("Use FirebaseOptionsBuilder")
    }
    get() = projectId

actual var FirebaseOptions.storageBucket: String
    set(value) {
        throw Throwable("Use FirebaseOptionsBuilder")
    }
    get() = storageBucket

actual var FirebaseOptions.messagingSenderId: String
    set(value) {
        throw Throwable("Use FirebaseOptionsBuilder")
    }
    get() = gcmSenderId

actual var FirebaseOptions.appId: String
    set(value) {
        throw Throwable("Use FirebaseOptionsBuilder")
    }
    get() = applicationId


actual typealias FirebaseOptionsBuilder  = com.google.firebase.FirebaseOptions.Builder

actual var FirebaseOptionsBuilder.apiKey: String
    set(value) {
        setApiKey(value)
    }
    get() = throw Throwable("Use FirebaseOptionsBuilder.Builder")

actual var FirebaseOptionsBuilder.authDomain: String
    set(value) {

    }
    get() = throw Throwable("Use FirebaseOptionsBuilder.Builder")

actual var FirebaseOptionsBuilder.databaseUrl: String
    set(value) {
        setDatabaseUrl(value)
    }
    get() = throw Throwable("Use FirebaseOptionsBuilder.Builder")

actual var FirebaseOptionsBuilder.projectId: String
    set(value) {
        setProjectId(value)
    }
    get() = throw Throwable("Use FirebaseOptionsBuilder.Builder")

actual var FirebaseOptionsBuilder.storageBucket: String
    set(value) {
        setStorageBucket(storageBucket)
    }
    get() = throw Throwable("Use FirebaseOptionsBuilder.Builder")

actual var FirebaseOptionsBuilder.messagingSenderId: String
    set(value) {
        setGcmSenderId(value)
    }
    get() = throw Throwable("Use FirebaseOptionsBuilder.Builder")

actual var FirebaseOptionsBuilder.appId: String
    set(value) {
        setApplicationId(appId)
    }
    get() = throw Throwable("Use FirebaseOptionsBuilder.Builder")

actual fun FirebaseOptionsBuilder.build(): FirebaseOptions = build()