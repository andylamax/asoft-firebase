package com.asofttz.firebase.storage

actual class Reference {

    actual val root: Reference
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    actual fun child(path: String?): Reference {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual fun put(data: Any): UploadTask {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

actual suspend fun Reference.getDownloadUrlAsync(): String? = null

actual suspend fun Reference.deleteAsync() = false