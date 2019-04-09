package com.asofttz.firebase.firestore

actual external class DocumentSnapshot {
    actual val id: String
    actual fun data(): DocumentData?
}