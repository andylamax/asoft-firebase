package com.asofttz.firebase.firestore.document

import com.asofttz.firebase.firestore.snapshot.DocumentSnapshot
import com.asofttz.firebase.firestore.FirebaseFirestore
import com.asofttz.firebase.firestore.collection.CollectionReference
import kotlinx.serialization.KSerializer

actual class DocumentReference {

}

actual val DocumentReference.Firestore: FirebaseFirestore
    get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
actual inline val DocumentReference.id: String
    get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

actual fun DocumentReference.collection(path: String): CollectionReference {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}

actual suspend fun DocumentReference.get(then: suspend (DocumentSnapshot) -> Unit) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}

actual suspend fun <T> DocumentReference.set(data: T, serializer: KSerializer<T>,then: suspend () -> Unit) {}