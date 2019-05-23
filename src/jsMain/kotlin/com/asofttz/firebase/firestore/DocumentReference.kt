package com.asofttz.firebase.firestore

import kotlinx.coroutines.await
import kotlin.js.Promise

actual external class DocumentReference {
    actual val firestore: Firestore
    actual val id: String
    actual fun collection(path: String): CollectionReference
    fun get(): Promise<DocumentSnapshot>
    actual fun set(obj: Any): Any
}

external object Object {
    fun <T> assign(target: T, vararg sources: Any): T
}

actual fun DocumentReference.save(obj: Any): Any = set(JSON.parse(JSON.stringify(obj)))

actual suspend fun <T> DocumentReference.toObject(t: T?): T? {
    val obj = get().await().toObject(t)
    return if (obj != null) {
        Object.assign<T>(t!!, obj!!)
    } else {
        null
    }
}