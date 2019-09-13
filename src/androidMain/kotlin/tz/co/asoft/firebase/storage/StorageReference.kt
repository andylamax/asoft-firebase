package tz.co.asoft.firebase.storage

import android.net.Uri
import tz.co.asoft.firebase.firestore.tools.await
import tz.co.asoft.io.file.File
import java.io.InputStream

actual typealias StorageReference = com.google.firebase.storage.StorageReference

actual val StorageReference.root: StorageReference get() = root

actual fun StorageReference.child(path: String): StorageReference = child(path)

actual fun StorageReference.put(file: File): UploadTask = when (val f = file.ref) {
    is ByteArray -> putBytes(f)
    is Uri -> putFile(f)
    is InputStream -> putStream(f)
    else -> throw Exception("Firebase storage can't put data of type ${f::class}")
}

actual suspend fun StorageReference.downloadUrl(): String? = downloadUrl.await().toString()

actual suspend fun StorageReference.delete() {
    delete().await()
}