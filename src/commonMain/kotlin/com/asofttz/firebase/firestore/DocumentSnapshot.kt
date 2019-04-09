package com.asofttz.firebase.firestore

expect class DocumentSnapshot {
    val id : String
    fun data() : DocumentData?
}