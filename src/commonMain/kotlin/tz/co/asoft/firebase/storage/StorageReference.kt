package tz.co.asoft.firebase.storage

import tz.co.asoft.io.File

expect class StorageReference

expect val StorageReference.root: StorageReference
expect fun StorageReference.child(path: String): StorageReference

/**
 * JavaScript Accepts:  Blob, Uint8Array and ArrayBuffer
 * Android Accepts:     ByteArray, android.content.Uri, InputStream
 */
expect fun StorageReference.upload(file: File): UploadTask

expect suspend fun StorageReference.downloadUrl(): String?
expect suspend fun StorageReference.remove()