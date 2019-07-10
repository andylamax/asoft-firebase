package tz.co.asoft.firebase.core

import tz.co.asoft.firebase.auth.FirebaseAuth
import tz.co.asoft.firebase.firestore.FirebaseFirestore
import tz.co.asoft.firebase.storage.FirebaseStorage

actual external class FirebaseApp {
    val name: String
    val options: FirebaseOptions
    fun firestore() : FirebaseFirestore
    fun storage() : FirebaseStorage
    fun auth() : FirebaseAuth
}

actual val FirebaseApp.name: String
    get() = name

actual val FirebaseApp.options: FirebaseOptions
    get() = options