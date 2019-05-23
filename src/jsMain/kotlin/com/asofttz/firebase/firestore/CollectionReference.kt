package com.asofttz.firebase.firestore

import kotlinx.coroutines.await
import kotlin.js.Promise

actual external class CollectionReference {
    actual val firestore: Firestore
    actual val id: String
    @JsName("doc")
    actual fun document(path: String): DocumentReference

    fun get(): Promise<QuerySnapshot>

    actual fun set(obj: Any): Any
    fun where(field: String, opStr: String, value: Any): Query
}

actual fun CollectionReference.whereEqualTo(field: String, value: Any): Query = where(field, "==", value)

actual suspend fun CollectionReference.forEach(callback: (QueryDocumentSnapshot) -> Unit) {
    val docs = get().await().forEach(callback)
}