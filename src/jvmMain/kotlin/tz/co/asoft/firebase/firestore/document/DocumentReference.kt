package tz.co.asoft.firebase.firestore.document

import kotlinx.serialization.KSerializer
import tz.co.asoft.firebase.firestore.FirebaseFirestore
import tz.co.asoft.firebase.firestore.collection.CollectionReference
import tz.co.asoft.firebase.firestore.snapshot.DocumentSnapshot

actual class DocumentReference

actual val DocumentReference.Firestore: FirebaseFirestore
    get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
actual val DocumentReference.id: String
    get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

actual fun DocumentReference.collection(path: String): CollectionReference {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}

actual suspend fun DocumentReference.get(then: suspend (DocumentSnapshot) -> Unit) {
}

actual suspend fun <T> DocumentReference.set(
        data: T,
        serializer: KSerializer<T>,
        then: suspend () -> Unit
) {
}