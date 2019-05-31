package com.asofttz.firebase.firestore

expect class DocumentReference {
    val firestore: Firestore
    val id: String
    fun collection(path: String): CollectionReference
}

expect suspend fun DocumentReference.save(json: String)

expect suspend fun DocumentReference.save(obj: Any)

expect suspend fun <T> DocumentReference.toObject(t: T? = null): T?

expect suspend fun DocumentReference.toJson(): String?

expect suspend fun DocumentReference.updateAsync(obj: Any)

expect suspend fun DocumentReference.updateAsync(json: String)