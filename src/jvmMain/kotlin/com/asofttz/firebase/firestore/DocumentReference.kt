package com.asofttz.firebase.firestore

actual class DocumentReference {
    actual val firestore: Firestore
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    actual val id: String
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    actual fun collection(path: String): CollectionReference {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual fun set(obj: Any): Any {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

actual fun DocumentReference.save(obj: Any): Any {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}

actual suspend fun <T> DocumentReference.toObject(t: T?): T? {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}