package tz.co.asoft.firebase.storage

import kotlinx.coroutines.await
import org.khronos.webgl.ArrayBuffer
import org.khronos.webgl.Uint8Array
import org.w3c.files.Blob
import tz.co.asoft.io.File
import kotlin.js.Promise

actual external class StorageReference {
    val root: StorageReference
    fun getDownloadURL(): Promise<String?>
    fun delete(): Promise<Any?>
    fun child(path: String?): StorageReference
    fun put(data: Any): UploadTask
}

actual val StorageReference.root: StorageReference get() = root

actual fun StorageReference.child(path: String): StorageReference = child(path)

actual fun StorageReference.upload(file: File): UploadTask = when (val f = file.ref) {
    is Blob, is Uint8Array, is ArrayBuffer -> put(f)
    else -> throw Exception("Firebase storage can't upload data of type ${f::class}")
}

actual suspend fun StorageReference.downloadUrl() = getDownloadURL().await()

actual suspend fun StorageReference.remove() {
    delete().await()
}