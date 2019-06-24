package com.asofttz.firebase.firestore.document

import com.asofttz.firebase.firestore.snapshot.DocumentSnapshot
import com.asofttz.firebase.firestore.FirebaseFirestore
import com.asofttz.firebase.firestore.collection.CollectionReference
import com.asofttz.firebase.firestore.tools.await
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

actual typealias DocumentReference = com.google.firebase.firestore.DocumentReference

actual val DocumentReference.Firestore: FirebaseFirestore
    get() = firestore

actual inline val DocumentReference.id: String
    get() = id

actual suspend fun DocumentReference.get(then: suspend (DocumentSnapshot) -> Unit) {
    then(get().await())
}

actual fun DocumentReference.col(path: String): CollectionReference = collection(path)

actual suspend fun DocumentReference.set(data: Any, then: suspend () -> Unit) {
    set(data).await()
    then()
}