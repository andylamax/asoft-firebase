package com.asofttz.firebase.storage

expect class UploadTask

expect fun UploadTask.onProgress(call: (UploadTaskSnapshot)->Unit)

expect suspend fun UploadTask.await()