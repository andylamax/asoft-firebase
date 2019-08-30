package tz.co.asoft.firebase.storage

actual class UploadTask

actual fun UploadTask.onProgress(call: (UploadTaskSnapshot) -> Unit) {
}

actual suspend fun UploadTask.await() {
}