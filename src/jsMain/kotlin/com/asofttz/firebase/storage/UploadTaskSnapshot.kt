package com.asofttz.firebase.storage

actual external class UploadTaskSnapshot {
    actual val bytesTransferred: Number
    actual val downloadURL: String?
    actual val ref: Reference
    actual val task: UploadTask
    actual val totalBytes: Number
}