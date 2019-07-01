package com.asofttz.firebase.storage

import android.net.Uri
import com.asofttz.firebase.firestore.tools.await
import java.io.InputStream

actual typealias StorageReference = com.google.firebase.storage.StorageReference

actual val StorageReference.root: StorageReference get() = root

actual fun StorageReference.child(path: String): StorageReference = child(path)

actual fun StorageReference.put(data: Any): UploadTask = when (data) {
    is ByteArray -> putBytes(data)
    is Uri -> putFile(data)
    is InputStream -> putStream(data)
    else -> throw Exception("Firebase storage can't put data of type ${data::class}")
}

actual suspend fun StorageReference.downloadUrl(): String? = downloadUrl.await().toString()

actual suspend fun StorageReference.delete() {
    delete().await()
}