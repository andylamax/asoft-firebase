package tz.co.asoft.firebase.storage

import com.google.firebase.storage.UploadTask

class AndroidUploadTaskSnapshot(private val snapshot: UploadTask.TaskSnapshot) : UploadTaskSnapshot() {
    override val bytesTransferred get() = snapshot.bytesTransferred
    override val downloadURL = snapshot.toString()
    override val totalBytes get() = snapshot.totalByteCount
}