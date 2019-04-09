package com.asofttz.firebase.firestore

actual external class CollectionReference {
    actual val firestore: Firestore
    actual val id: String
    @JsName("doc")
    actual fun document(path: String): DocumentReference

    actual fun get(): FirestoreResponse
    actual fun set(obj: Any): Any
    fun where(field: String, opStr: String, value: Any): Query
}

actual fun CollectionReference.whereEqualTo(field: String, value: Any): Query = where(field, "==", value)