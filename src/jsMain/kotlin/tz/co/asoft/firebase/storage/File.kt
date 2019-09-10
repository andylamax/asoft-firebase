package tz.co.asoft.firebase.storage

import org.khronos.webgl.ArrayBuffer
import org.khronos.webgl.Uint8Array
import org.w3c.files.Blob

actual class File private actual constructor(actual val ref: Any) {
    constructor(blob: Blob) : this(blob as Any)
    constructor(uInt8Array: Uint8Array) : this(uInt8Array as Any)
    constructor(arrayBuffer: ArrayBuffer) : this(arrayBuffer as Any)
    actual constructor(byteArray: ByteArray) : this(byteArray.toTypedArray())
}