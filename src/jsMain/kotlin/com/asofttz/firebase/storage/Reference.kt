package com.asofttz.firebase.storage

import kotlinx.coroutines.await
import kotlin.js.Promise

actual external class Reference {
    actual val root: Reference

    fun getDownloadUrl(): Promise<String?>
    fun delete(): Promise<Any?>
    actual fun child(path: String?): Reference
    actual fun put(data: Any): UploadTask
}

actual suspend fun Reference.getDownloadUrlAsync() = getDownloadUrl().await()

actual suspend fun Reference.deleteAsync() = delete().await() != null