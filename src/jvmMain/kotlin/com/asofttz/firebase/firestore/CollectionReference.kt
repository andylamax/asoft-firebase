package com.asofttz.firebase.firestore

actual class CollectionReference {
    actual val firestore: Firestore
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    actual val id: String
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    actual fun document(path: String): DocumentReference {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

actual fun CollectionReference.whereEqualTo(field: String, value: Any): Query {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}

actual suspend fun CollectionReference.forEach(callback: (QueryDocumentSnapshot) -> Unit) {
}

actual suspend fun CollectionReference.addAsync(data: Any): DocumentReference {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}

actual suspend fun CollectionReference.addAsync(json: String): DocumentReference {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}