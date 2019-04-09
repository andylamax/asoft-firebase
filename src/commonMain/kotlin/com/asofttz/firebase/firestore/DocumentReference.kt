package com.asofttz.firebase.firestore

expect class DocumentReference {
    val firestore: Firestore
    val id: String
    fun collection(path: String) : CollectionReference
    fun get() : Any
    fun set(obj: Any) : Any
}

expect fun DocumentReference.save(obj: Any) : Any