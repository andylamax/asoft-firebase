package com.asofttz.firebase.storage

actual class UploadTask {
}

actual suspend fun UploadTask.await() {
    TODO()
}

actual fun UploadTask.onProgress(call: (UploadTaskSnapshot) -> Unit) {
}