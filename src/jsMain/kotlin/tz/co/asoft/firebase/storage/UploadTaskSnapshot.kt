package tz.co.asoft.firebase.storage

external class TaskSnapshot {
    val bytesTransferred: Number
    val downloadURL: String?
    val ref: StorageReference
    val task: UploadTask
    val totalBytes: Number
}

class JSTaskSnapshot(private val snapshot: TaskSnapshot) : UploadTaskSnapshot() {
    override val bytesTransferred get() = "${snapshot.bytesTransferred}".toLong()
    override val downloadURL get() = snapshot.toString()
    override val totalBytes get() = "${snapshot.totalBytes}".toLong()
}