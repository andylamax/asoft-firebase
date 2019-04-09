package com.asofttz.firebase.firestore

actual class QueryDocumentSnapshot {
    actual val id: String get() = TODO("to be implemented")
    actual val exists: Boolean
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    actual fun data(): DocumentData {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual fun get(field: String) {
    }

    actual fun isEqual() {
    }
}

actual fun <T> QueryDocumentSnapshot.toObject(t: T?): T {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}