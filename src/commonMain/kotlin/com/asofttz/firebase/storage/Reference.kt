package com.asofttz.firebase.storage

expect class Reference {
    val root: Reference
    fun child(path: String?) : Reference
    fun put(data: Any) : UploadTask
}

expect suspend fun Reference.getDownloadUrlAsync() : String?
expect suspend fun Reference.deleteAsync() : Boolean