package com.asofttz.firebase.firestore

expect class DocumentSnapshot {
    val id : String
    fun data() : DocumentData?
}

expect fun <T> DocumentSnapshot.toObject(t: T? = null) : T?