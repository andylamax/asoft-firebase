package tz.co.asoft.firebase.core

actual typealias FirebaseOptions = com.google.firebase.FirebaseOptions

actual var FirebaseOptions.apiKey: String
    set(_) {}
    get() = apiKey

actual var FirebaseOptions.authDomain: String
    set(_) {}
    get() = ""

actual var FirebaseOptions.databaseUrl: String?
    set(_) {}
    get() = databaseUrl

actual var FirebaseOptions.projectId: String?
    set(_) {}
    get() = projectId

actual var FirebaseOptions.storageBucket: String?
    set(_) {}
    get() = storageBucket

actual var FirebaseOptions.messagingSenderId: String?
    set(_) {}
    get() = gcmSenderId

actual var FirebaseOptions.appId: String
    set(_) {}
    get() = applicationId


actual typealias FirebaseOptionsBuilder = com.google.firebase.FirebaseOptions.Builder

actual var FirebaseOptionsBuilder.apiKey: String
    set(value) {
        setApiKey(value)
    }
    get() = ""

actual var FirebaseOptionsBuilder.authDomain: String
    set(value) {

    }
    get() = ""

actual var FirebaseOptionsBuilder.databaseUrl: String
    set(value) {
        setDatabaseUrl(value)
    }
    get() = ""

actual var FirebaseOptionsBuilder.projectId: String
    set(value) {
        setProjectId(value)
    }
    get() = ""

actual var FirebaseOptionsBuilder.storageBucket: String
    set(value) {
        setStorageBucket(value)
    }
    get() = ""

actual var FirebaseOptionsBuilder.messagingSenderId: String
    set(value) {
        setGcmSenderId(value)
    }
    get() = ""

actual var FirebaseOptionsBuilder.appId: String
    set(value) {
        setApplicationId(value)
    }
    get() = ""

actual fun FirebaseOptionsBuilder.build(): FirebaseOptions = build()