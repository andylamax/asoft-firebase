package tz.co.asoft.firebase.core

fun Map<String, *>.toFirebaseOption() = FirebaseOptionsBuilder().also {
    val apiKey: String by this
    val authDomain: String by this
    val databaseURL: String by this
    val projectId: String by this
    val storageBucket: String by this
    val messagingSenderId: String by this
    val appId: String by this
//    val measurementId: String by this
    it.apiKey = apiKey
    it.authDomain = authDomain
    it.databaseUrl = databaseURL
    it.projectId = projectId
    it.storageBucket = storageBucket
    it.messagingSenderId = messagingSenderId
    it.appId = appId
}.build()