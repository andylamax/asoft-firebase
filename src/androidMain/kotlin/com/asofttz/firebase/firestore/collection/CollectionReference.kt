package com.asofttz.firebase.firestore.collection

import com.asofttz.firebase.firestore.document.DocumentReference
import com.asofttz.firebase.firestore.FirebaseFirestore
import com.asofttz.firebase.firestore.snapshot.QueryDocumentSnapshot
import com.asofttz.firebase.firestore.snapshot.QuerySnapshot
import com.asofttz.firebase.firestore.tools.await
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.serialization.KSerializer
import kotlin.coroutines.resume

actual typealias CollectionReference = com.google.firebase.firestore.CollectionReference

actual val CollectionReference.firestore: FirebaseFirestore
    get() = firestore

actual val CollectionReference.id: String
    get() = id

actual val CollectionReference.parent: DocumentReference?
    get() = parent

actual val CollectionReference.path: String
    get() = path

actual fun CollectionReference.doc(documentPath: String?): DocumentReference {
    return if (documentPath != null) {
        document(documentPath)
    } else {
        document()
    }
}

actual suspend fun CollectionReference.get(then: suspend (QuerySnapshot) -> Unit) {
    then(get().await())
}

actual suspend fun CollectionReference.forEachAsync(action: (QueryDocumentSnapshot) -> Unit): Unit {
    get().await().forEach(action)
}

actual suspend fun <T> CollectionReference.add(data: T, serializer: KSerializer<T>, then: suspend (DocumentReference) -> Unit) {
    then(add(data as Any).await())
}