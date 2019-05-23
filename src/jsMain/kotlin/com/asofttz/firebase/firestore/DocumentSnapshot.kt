package com.asofttz.firebase.firestore

actual external class DocumentSnapshot {
    actual val id: String
    actual fun data(): DocumentData?
}

actual fun <T> DocumentSnapshot.toObject(t: T?): T? {
    val obj = data().unsafeCast<T>()
    return if (obj == undefined) {
        null
    } else {
        Object.assign<T>(t!!,obj!!)
    }
}