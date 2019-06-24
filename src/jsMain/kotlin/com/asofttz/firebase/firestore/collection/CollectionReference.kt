package com.asofttz.firebase.firestore.collection

import com.asofttz.firebase.firestore.FirebaseFirestore
import com.asofttz.firebase.firestore.document.DocumentReference
import com.asofttz.firebase.firestore.document.Object
import com.asofttz.firebase.firestore.snapshot.QueryDocumentSnapshot
import com.asofttz.firebase.firestore.snapshot.QuerySnapshot
import kotlinx.coroutines.await
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine
import kotlin.js.*

actual external class CollectionReference {
    val firestore: FirebaseFirestore
    val id: String
    val parent: DocumentReference?
    val path: String

    @JsName("doc")
    fun doc(path: String? = definedExternally): DocumentReference

    fun get(): Promise<QuerySnapshot>

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

actual suspend inline fun CollectionReference.get(then: suspend (QuerySnapshot) -> Unit) {
    then(get().await())
}

actual suspend fun CollectionReference.forEachAsync(action: (QueryDocumentSnapshot) -> Unit) {
    get().await().forEach(action)
}

actual suspend inline fun <T> CollectionReference.add(data: T, serializer: KSerializer<T>, then: suspend (DocumentReference) -> Unit) {
    val json = Json.stringify(serializer, data)
    then(add(JSON.parse(json)).await())
}