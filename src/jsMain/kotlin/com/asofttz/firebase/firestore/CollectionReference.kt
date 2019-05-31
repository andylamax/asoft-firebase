package com.asofttz.firebase.firestore

import kotlinx.coroutines.await
import kotlin.js.Promise

actual external class CollectionReference {
    actual val firestore: Firestore
    actual val id: String
    @JsName("doc")
    actual fun document(path: String): DocumentReference

    fun get(): Promise<QuerySnapshot>

    fun add(obj: Any): Promise<DocumentReference>

    fun where(field: String, opStr: String, value: Any): Query
}

actual fun CollectionReference.whereEqualTo(field: String, value: Any): Query = where(field, "==", value)

actual suspend fun CollectionReference.forEach(callback: (QueryDocumentSnapshot) -> Unit) {
    val docs = get().await().forEach(callback)
}

actual suspend fun CollectionReference.addAsync(json: String): DocumentReference {
    val data = JSON.parse<Any>(json)
    return addAsync(data)
}

actual suspend fun CollectionReference.addAsync(data: Any): DocumentReference {
    return add(Object.assign(js("{}"),data as Any) as Any).await()
}