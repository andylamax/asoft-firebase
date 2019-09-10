package tz.co.asoft.firebase.firestore.batch

import kotlinx.serialization.KSerializer
import tz.co.asoft.firebase.firestore.document.DocumentReference

expect class WriteBatch {
    fun delete(documentReference: DocumentReference): WriteBatch
}

expect fun <T : Any> WriteBatch.put(
    documentReference: DocumentReference,
    data: T,
    serializer: KSerializer<T>
): WriteBatch

expect suspend fun WriteBatch.submit()