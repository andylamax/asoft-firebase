package com.asofttz.firebase.firestore

expect class CollectionReference {
    val firestore: Firestore
    val id: String

    fun document(path: String): DocumentReference

    fun set(obj: Any): Any
}

expect fun CollectionReference.whereEqualTo(field: String, value: Any): Query

expect suspend fun CollectionReference.forEach(callback: (QueryDocumentSnapshot) -> Unit)