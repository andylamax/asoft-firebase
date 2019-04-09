package com.asofttz.firebase.firestore

expect class QueryDocumentSnapshot {
    val id: String
    val exists: Boolean
    fun data(): DocumentData
    fun get(field: String)
    fun isEqual()
}

expect fun <T> QueryDocumentSnapshot.toObject(t: T? = null): T