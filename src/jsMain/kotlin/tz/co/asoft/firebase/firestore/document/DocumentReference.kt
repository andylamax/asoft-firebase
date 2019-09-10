package tz.co.asoft.firebase.firestore.document

import tz.co.asoft.firebase.firestore.snapshot.DocumentSnapshot
import tz.co.asoft.firebase.firestore.FirebaseFirestore
import tz.co.asoft.firebase.firestore.collection.CollectionReference
import kotlinx.coroutines.await
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import tz.co.asoft.firebase.firestore.event.Listener
import kotlin.js.Promise

actual external class DocumentReference {
    val firestore: FirebaseFirestore
    val id: String
    fun collection(path: String): CollectionReference
    fun get(): Promise<DocumentSnapshot>
    fun set(obj: Any): Promise<Unit>
    fun update(data: Any): Promise<Unit>
    fun onSnapshot(l: Listener<DocumentSnapshot>)
}

actual val DocumentReference.firestore: FirebaseFirestore
    get() = firestore


actual val DocumentReference.id: String
    get() = id

actual fun DocumentReference.collection(path: String): CollectionReference = collection(path)

actual suspend fun DocumentReference.get(then: suspend (DocumentSnapshot) -> Unit) {
    then(get().await())
}

actual suspend fun <T> DocumentReference.set(data: T, serializer: KSerializer<T>, then: suspend () -> Unit) {
    val obj = JSON.parse<Any>(Json.stringify(serializer, data))
    set(obj).await()
    then()
}

actual suspend fun DocumentReference.fetch(): DocumentSnapshot = get().await()

actual suspend fun <T : Any> DocumentReference.put(data: T, serializer: KSerializer<T>) {
    val obj = JSON.parse<Any>(Json.stringify(serializer, data))
    set(obj).await()
}

actual fun DocumentReference.addListener(listener: (DocumentSnapshot) -> Unit) {
    onSnapshot(Listener(
        next = { listener(it) },
        error = {}
    ))
}