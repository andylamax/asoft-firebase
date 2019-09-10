package tz.co.asoft.firebase.firestore.batch

import kotlinx.serialization.KSerializer
import tz.co.asoft.firebase.firestore.document.DocumentReference

actual class WriteBatch {
    actual fun delete(documentReference: DocumentReference): WriteBatch {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

actual fun <T : Any> WriteBatch.put(
    documentReference: DocumentReference,
    data: T,
    serializer: KSerializer<T>
): WriteBatch {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}

actual suspend fun WriteBatch.submit() {
}