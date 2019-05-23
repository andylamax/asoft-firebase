package com.asofttz.firebase.firestore

expect class DocumentReference {
    val firestore: Firestore
    val id: String
    fun collection(path: String): CollectionReference
    fun set(obj: Any): Any
}

expect fun DocumentReference.save(obj: Any): Any

expect suspend fun <T> DocumentReference.toObject(t: T? = null): T?