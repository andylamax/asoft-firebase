package com.asofttz.firebase.storage

import com.asofttz.firebase.core.FirebaseApp

actual external class FirebaseStorage {
    val app: FirebaseApp
    fun ref(path: String?): StorageReference
}

actual fun FirebaseApp.storage(): FirebaseStorage = storage()
actual val FirebaseStorage.app: FirebaseApp get() = app
actual fun FirebaseStorage.ref(path: String?): StorageReference = ref(path)