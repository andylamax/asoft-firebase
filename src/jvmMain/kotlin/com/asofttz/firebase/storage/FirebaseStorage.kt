package com.asofttz.firebase.storage

import com.asofttz.firebase.core.FirebaseApp

actual class FirebaseStorage

actual fun FirebaseApp.storage(): FirebaseStorage {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}

actual val FirebaseStorage.app: FirebaseApp
    get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

actual fun FirebaseStorage.ref(path: String?): StorageReference {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}