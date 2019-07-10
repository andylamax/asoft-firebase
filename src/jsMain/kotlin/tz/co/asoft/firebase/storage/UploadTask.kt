package tz.co.asoft.firebase.storage

import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

actual external class UploadTask {
    fun on(event: String, progress: ((TaskSnapshot) -> Unit)?, error: ((dynamic) -> Unit)?, complete: (() -> Unit)?)
}

actual suspend fun UploadTask.await() = suspendCancellableCoroutine<Unit> { cont ->
    on(
            event = "state_changed",
            progress = null,
            error = {
                cont.resumeWithException(Throwable("Failed"))
            },
            complete = {
                cont.resume(Unit)
            }
    )
}

actual fun UploadTask.onProgress(call: (UploadTaskSnapshot) -> Unit) = on(
        event = "state_changed",
        progress = {
            call(JSTaskSnapshot(it))
        },
        error = null,
        complete = null
)