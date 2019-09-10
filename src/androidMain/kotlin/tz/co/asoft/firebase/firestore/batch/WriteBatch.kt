package tz.co.asoft.firebase.firestore.batch

import kotlinx.serialization.KSerializer
import tz.co.asoft.firebase.firestore.document.DocumentReference
import tz.co.asoft.firebase.firestore.tools.await

actual typealias WriteBatch = com.google.firebase.firestore.WriteBatch

actual fun <T : Any> WriteBatch.put(
    documentReference: DocumentReference,
    data: T,
    serializer: KSerializer<T>
): WriteBatch = set(documentReference, data)

actual suspend fun WriteBatch.submit() {
    commit().await()
}