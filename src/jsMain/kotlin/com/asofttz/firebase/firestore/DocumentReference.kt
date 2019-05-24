package com.asofttz.firebase.firestore

import kotlinx.coroutines.await
import kotlin.js.Promise

actual external class DocumentReference {
    actual val firestore: Firestore
    actual val id: String
    actual fun collection(path: String): CollectionReference
    fun get(): Promise<DocumentSnapshot>
    fun set(obj: Any): Promise<Unit>
}

external object Object {
    fun <T> assign(target: T, vararg sources: Any): T
}

actual suspend fun DocumentReference.save(json: String) {
    val obj = JSON.parse<Any>(json)
    return save(obj)
}

actual suspend fun DocumentReference.save(obj: Any) = set(Object.assign(js("{}") as Any, obj)).await()

actual suspend fun <T> DocumentReference.toObject(t: T?): T? = get().await().toObject(t)

actual suspend fun DocumentReference.toJson(): String? = JSON.stringify(toObject(Unit))