package tz.co.asoft.firebase.core

actual class FirebaseOptions {}

actual var FirebaseOptions.apiKey: String
    get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    set(value) {}
actual var FirebaseOptions.authDomain: String
    get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    set(value) {}
actual var FirebaseOptions.databaseUrl: String?
    get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    set(value) {}
actual var FirebaseOptions.projectId: String?
    get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    set(value) {}
actual var FirebaseOptions.storageBucket: String?
    get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    set(value) {}
actual var FirebaseOptions.messagingSenderId: String?
    get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    set(value) {}
actual var FirebaseOptions.appId: String
    get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    set(value) {}

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

actual fun FirebaseOptionsBuilder.build(): FirebaseOptions = FirebaseOptions()