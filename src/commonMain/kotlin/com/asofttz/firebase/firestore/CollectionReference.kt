package com.asofttz.firebase.firestore

expect class CollectionReference {
    val firestore: Firestore
    val id: String
    fun document(path: String): DocumentReference
}

expect suspend fun CollectionReference.addAsync(json: String) : DocumentReference

expect suspend fun CollectionReference.addAsync(data: Any) : DocumentReference

expect fun CollectionReference.whereEqualTo(field: String, value: Any): Query

expect suspend fun CollectionReference.forEach(callback: (QueryDocumentSnapshot) -> Unit)