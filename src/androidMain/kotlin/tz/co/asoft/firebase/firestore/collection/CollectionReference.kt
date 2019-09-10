package tz.co.asoft.firebase.firestore.collection

import tz.co.asoft.firebase.firestore.FirebaseFirestore
import tz.co.asoft.firebase.firestore.document.DocumentReference
import tz.co.asoft.firebase.firestore.snapshot.QueryDocumentSnapshot
import tz.co.asoft.firebase.firestore.tools.await
import kotlinx.serialization.KSerializer
import tz.co.asoft.firebase.firestore.snapshot.QuerySnapshot

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

actual suspend fun CollectionReference.forEachAsync(action: (QueryDocumentSnapshot) -> Unit): Unit {
    get().await().forEach(action)
}

actual suspend fun <T> CollectionReference.add(
    data: T,
    serializer: KSerializer<T>,
    then: suspend (DocumentReference) -> Unit
) {
    then(add(data as Any).await())
}

actual suspend fun <T : Any> CollectionReference.put(data: T, serializer: KSerializer<T>) = add(data).await()

actual fun CollectionReference.addListener(listener: (QuerySnapshot) -> Unit) {
    addSnapshotListener { qs, _ -> qs?.let { listener(it) } }
}