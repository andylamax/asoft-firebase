package tz.co.asoft.firebase.storage

import kotlin.math.round

abstract class UploadTaskSnapshot {
    abstract val bytesTransferred: Long
    abstract val downloadURL: String?
    abstract val totalBytes: Long

    val pct get() = round(10000 * bytesTransferred.toDouble() / totalBytes) / 100
}