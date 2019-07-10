package tz.co.asoft.firebase.storage

import tz.co.asoft.firebase.core.FirebaseApp

actual typealias FirebaseStorage = com.google.firebase.storage.FirebaseStorage

actual val FirebaseStorage.app: FirebaseApp get() = app

actual fun FirebaseStorage.ref(path: String?): StorageReference = if(path!=null) {
    getReference(path)
} else {
    reference
}

actual fun FirebaseApp.storage(): FirebaseStorage = FirebaseStorage.getInstance(this)