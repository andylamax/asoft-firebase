package com.asofttz.firebase.storage

expect class StorageReference

expect val StorageReference.root: StorageReference
expect fun StorageReference.child(path: String): StorageReference

/**
 * JavaScript Accepts:  Blob, Uint8Array and ArrayBuffer
 * Android Accepts:     ByteArray, android.content.Uri, InputStream
 */
expect fun StorageReference.put(data: Any): UploadTask

expect suspend fun StorageReference.downloadUrl(): String?
expect suspend fun StorageReference.delete()