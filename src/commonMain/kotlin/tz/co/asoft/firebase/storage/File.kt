package tz.co.asoft.firebase.storage

expect class File private constructor(ref: Any) {
    val ref: Any
    constructor(byteArray: ByteArray)
}