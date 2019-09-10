package tz.co.asoft.firebase.firestore.collection

import tz.co.asoft.firebase.firestore.FirebaseFirestore
import tz.co.asoft.firebase.firestore.document.DocumentReference
import tz.co.asoft.firebase.firestore.query.Query
import tz.co.asoft.firebase.firestore.snapshot.QueryDocumentSnapshot
import kotlinx.coroutines.await
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import kotlin.js.*

actual external class CollectionReference : Query {
    val firestore: FirebaseFirestore
    val id: String
    val parent: DocumentReference?
    val path: String

    @JsName("doc")
    fun doc(path: String? = definedExternally): DocumentReference

    fun add(obj: Any): Promise<DocumentReference>
}

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
        doc(documentPath)
    } else {
        doc()
    }
}

actual suspend fun CollectionReference.forEachAsync(action: (QueryDocumentSnapshot) -> Unit) {
    get().await().forEach(action)
}

actual suspend fun <T> CollectionReference.add(
    data: T,
    serializer: KSerializer<T>,
    then: suspend (DocumentReference) -> Unit
) {
    val json = Json.nonstrict.stringify(serializer, data)
    then(add(JSON.parse(json)).await())
}

actual suspend fun <T : Any> CollectionReference.put(
    data: T,
    serializer: KSerializer<T>
): DocumentReference {
    val json = Json.nonstrict.stringify(serializer, data)
    return add(JSON.parse(json)).await()
}