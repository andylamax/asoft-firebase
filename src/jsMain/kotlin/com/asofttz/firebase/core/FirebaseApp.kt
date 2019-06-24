package com.asofttz.firebase.core

import com.asofttz.firebase.firestore.FirebaseFirestore

actual external class FirebaseApp {
    val name: String
    val options: FirebaseOptions
    fun firestore() : FirebaseFirestore
}

actual val FirebaseApp.name: String
    get() = name

actual val FirebaseApp.options: FirebaseOptions
    get() = options