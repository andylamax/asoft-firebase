package com.asofttz.firebase.storage

import kotlinx.coroutines.await
import org.khronos.webgl.ArrayBuffer
import org.khronos.webgl.Uint8Array
import org.w3c.files.Blob
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

actual fun StorageReference.put(data: Any): UploadTask = when (data) {
    is Blob -> put(data)
    is Uint8Array -> put(data)
    is ArrayBuffer -> put(data)
    else -> throw Exception("Firebase storage can't put data of type ${data::class}")
}

actual suspend fun StorageReference.downloadUrl() = getDownloadURL().await()

actual suspend fun StorageReference.delete() {
    delete().await() != null
}