package tz.co.asoft.firebase.firestore.document

import tz.co.asoft.firebase.firestore.FirebaseFirestore
import tz.co.asoft.firebase.firestore.collection.CollectionReference
import tz.co.asoft.firebase.firestore.snapshot.DocumentSnapshot
import tz.co.asoft.firebase.firestore.tools.await
import kotlinx.serialization.KSerializer

actual typealias DocumentReference = com.google.firebase.firestore.DocumentReference

actual val DocumentReference.Firestore: FirebaseFirestore
    get() = firestore

actual inline val DocumentReference.id: String
    get() = id

actual suspend fun DocumentReference.get(then: suspend (DocumentSnapshot) -> Unit) {
    then(get().await())
}

actual fun DocumentReference.collection(path: String): CollectionReference = collection(path)

actual suspend fun <T> DocumentReference.set(data: T, serializer: KSerializer<T>, then: suspend () -> Unit) {
    set(data as Any).await()
    then()
}