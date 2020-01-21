package tz.co.asoft.firebase.storage

import android.net.Uri
import tz.co.asoft.firebase.firestore.tools.await
import tz.co.asoft.io.File
import java.io.InputStream
import java.io.File as JavaFile

actual typealias StorageReference = com.google.firebase.storage.StorageReference

actual val StorageReference.root: StorageReference get() = root

actual fun StorageReference.child(path: String): StorageReference = child(path)

actual fun StorageReference.upload(file: File): UploadTask = when (val f = file.ref) {
    is ByteArray -> putBytes(f)
    is Uri -> putFile(f)
    is JavaFile -> putFile(Uri.fromFile(f))
    is InputStream -> putStream(f)
    else -> throw Exception("Firebase storage can't upload data of type ${f::class}")
}

actual suspend fun StorageReference.downloadUrl(): String? = downloadUrl.await().toString()

actual suspend fun StorageReference.remove() {
    delete().await()
}