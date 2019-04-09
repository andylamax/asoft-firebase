package com.asofttz.firebase.firestore

actual external class DocumentReference {
    actual val firestore: Firestore
    actual val id: String
    actual fun collection(path: String): CollectionReference
    actual fun get(): Any
    actual fun set(obj: Any): Any
}

external object Object {
    fun <T> assign(target: T, vararg sources: Any): T
}

actual fun DocumentReference.save(obj: Any): Any = set(JSON.parse(JSON.stringify(obj)))