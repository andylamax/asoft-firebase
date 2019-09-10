package tz.co.asoft.firebase.firestore.batch

import kotlinx.coroutines.await
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import tz.co.asoft.firebase.firestore.document.DocumentReference
import kotlin.js.Promise

actual external class WriteBatch {
    fun commit(): Promise<Unit>

    actual fun delete(documentReference: DocumentReference): WriteBatch

    fun set(documentReference: DocumentReference, data: Any): WriteBatch
}

actual fun <T : Any> WriteBatch.put(
    documentReference: DocumentReference,
    data: T,
    serializer: KSerializer<T>
): WriteBatch {
    val obj = JSON.parse<Any>(Json.stringify(serializer, data))
    return set(documentReference, obj)
}

actual suspend fun WriteBatch.submit() = commit().await()