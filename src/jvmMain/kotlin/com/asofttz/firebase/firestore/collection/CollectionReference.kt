package com.asofttz.firebase.firestore.collection

import com.asofttz.firebase.firestore.FirebaseFirestore
import com.asofttz.firebase.firestore.query.Query
import com.asofttz.firebase.firestore.document.DocumentReference
import com.asofttz.firebase.firestore.snapshot.QueryDocumentSnapshot
import com.asofttz.firebase.firestore.snapshot.QuerySnapshot
import kotlinx.serialization.KSerializer

actual class CollectionReference

actual val CollectionReference.firestore: FirebaseFirestore
    get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
actual val CollectionReference.id: String
    get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

actual fun CollectionReference.doc(documentPath: String?): DocumentReference {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}


actual val CollectionReference.parent: DocumentReference?
    get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
actual val CollectionReference.path: String
    get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

actual suspend fun CollectionReference.forEachAsync(action: (QueryDocumentSnapshot)->Unit) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}

actual suspend inline fun CollectionReference.get(then: suspend (QuerySnapshot) -> Unit) {
}

actual suspend inline fun <T> CollectionReference.add(data: T, serializer: KSerializer<T>, then: suspend (DocumentReference) -> Unit) {
}