package tz.co.asoft.firebase.storage

import java.io.InputStream

actual class File private actual constructor(actual val ref: Any) {
    actual constructor(byteArray: ByteArray) : this(byteArray as Any)
    constructor(inputStream: InputStream) : this(inputStream as Any)
}