package tz.co.asoft.firebase.storage

import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

actual typealias UploadTask = com.google.firebase.storage.UploadTask

actual suspend fun UploadTask.await() = suspendCancellableCoroutine<Unit> { cont ->
    addOnSuccessListener {
        cont.resume(Unit)
    }
    addOnFailureListener {
        cont.resumeWithException(it)
    }
}

actual fun UploadTask.onProgress(call: (UploadTaskSnapshot) -> Unit) {
    addOnProgressListener {
        call(AndroidUploadTaskSnapshot(it))
    }
}