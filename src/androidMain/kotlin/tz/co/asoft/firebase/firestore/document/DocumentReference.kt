@file:JvmName("DocumentReference")

package tz.co.asoft.firebase.firestore.document

import com.google.firebase.firestore.EventListener
import kotlinx.serialization.KSerializer
import tz.co.asoft.firebase.firestore.FirebaseFirestore
import tz.co.asoft.firebase.firestore.collection.CollectionReference
import tz.co.asoft.firebase.firestore.snapshot.DocumentSnapshot
import tz.co.asoft.firebase.firestore.tools.await

actual typealias DocumentReference = com.google.firebase.firestore.DocumentReference

actual val DocumentReference.firestore: FirebaseFirestore
    get() = firestore

actual val DocumentReference.id: String
    get() = id

actual suspend fun DocumentReference.get(then: suspend (DocumentSnapshot) -> Unit) {
    then(get().await())
}

actual fun DocumentReference.collection(path: String): CollectionReference = collection(path)

actual suspend fun <T> DocumentReference.set(data: T, serializer: KSerializer<T>, then: suspend () -> Unit) {
    set(data as Any).await()
    then()
}

actual suspend fun DocumentReference.fetch(): DocumentSnapshot = get().await()

actual suspend fun <T : Any> DocumentReference.put(data: T, serializer: KSerializer<T>) {
    set(data).await()
}

actual fun DocumentReference.addListener(listener: (DocumentSnapshot) -> Unit) {
    addSnapshotListener { doc, exp ->
        doc?.let { listener(it) }
    }
}
