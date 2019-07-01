package com.asofttz.firebase.core

import com.asofttz.firebase.firestore.FirebaseFirestore
import com.asofttz.firebase.storage.FirebaseStorage

actual external class FirebaseApp {
    val name: String
    val options: FirebaseOptions
    fun firestore() : FirebaseFirestore
    fun storage() : FirebaseStorage
}

actual val FirebaseApp.name: String
    get() = name

actual val FirebaseApp.options: FirebaseOptions
    get() = options