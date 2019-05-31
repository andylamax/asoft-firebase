package com.asofttz.firebase.storage

import kotlin.math.round

expect class UploadTaskSnapshot {
    val bytesTransferred: Number
    val downloadURL: String?
    //    val metadata
    val ref: Reference
    //    state
    val task: UploadTask
    val totalBytes: Number
}

val UploadTaskSnapshot.pct get() = round(10000 * "$bytesTransferred".toDouble() / "$totalBytes".toDouble()) / 100