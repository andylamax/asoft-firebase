package com.asofttz.firebase.firestore.document

import com.asofttz.firebase.firestore.snapshot.DocumentSnapshot
import com.asofttz.firebase.firestore.FirebaseFirestore
import com.asofttz.firebase.firestore.collection.CollectionReference
import kotlinx.coroutines.await
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import kotlin.coroutines.resume
import kotlin.js.Promise

actual external class DocumentReference {
    val firestore: FirebaseFirestore
    val id: String
    fun collection(path: String): CollectionReference
    fun get(): Promise<DocumentSnapshot>
    fun set(obj: Any): Promise<Unit>
    fun update(data: Any): Promise<Unit>
}

actual val DocumentReference.Firestore: FirebaseFirestore
    get() = firestore


actual inline val DocumentReference.id: String
    get() = id

actual fun DocumentReference.collection(path: String): CollectionReference = collection(path)

external object Object {
    fun <T> assign(target: T, sources: Any): T
}

actual suspend fun DocumentReference.get(then: suspend (DocumentSnapshot) -> Unit) {
    then(get().await())
}

actual suspend fun <T> DocumentReference.set(data: T, serializer: KSerializer<T>, then: suspend ()->Unit){
    val obj = JSON.parse<Any>(Json.stringify(serializer,data))
    set(obj).await()
    then()
}
