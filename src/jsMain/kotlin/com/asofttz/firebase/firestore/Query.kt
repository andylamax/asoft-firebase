package com.asofttz.firebase.firestore

actual external class Query {
    actual fun get(): FirestoreResponse
    fun where(field: String, opStr: String, value: Any): Query
}