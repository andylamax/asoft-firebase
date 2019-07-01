package com.asofttz.firebase.storage

actual class StorageReference

actual val StorageReference.root: StorageReference
    get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

actual fun StorageReference.child(path: String): StorageReference {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}

actual fun StorageReference.put(data: Any): UploadTask {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}

actual suspend fun StorageReference.downloadUrl(): String? = null

actual suspend fun StorageReference.delete() {
    TODO()
}