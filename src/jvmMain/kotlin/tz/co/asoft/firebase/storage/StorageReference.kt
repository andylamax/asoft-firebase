package tz.co.asoft.firebase.storage

actual class StorageReference

actual val StorageReference.root: StorageReference
    get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

actual fun StorageReference.child(path: String): StorageReference {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}

/**
 * JavaScript Accepts:  Blob, Uint8Array and ArrayBuffer
 * Android Accepts:     ByteArray, android.content.Uri, InputStream
 */
actual fun StorageReference.put(file: File): UploadTask {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}

actual suspend fun StorageReference.downloadUrl(): String? {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}

actual suspend fun StorageReference.delete() {
}