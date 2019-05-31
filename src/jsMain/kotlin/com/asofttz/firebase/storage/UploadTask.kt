package com.asofttz.firebase.storage

actual external class UploadTask {
    fun on(event: String, progress: ((UploadTaskSnapshot) -> Unit)?, error: ((dynamic) -> Unit)?, complete: (() -> Unit)?)
}