package com.asofttz.firebase.firestore

actual external class QueryDocumentSnapshot {
    actual val id: String
    actual val exists: Boolean
    actual fun data(): DocumentData

    actual fun get(field: String)
    actual fun isEqual()
}

actual fun <T> QueryDocumentSnapshot.toObject(t: T?) : T = Object.assign(t!!,data())
