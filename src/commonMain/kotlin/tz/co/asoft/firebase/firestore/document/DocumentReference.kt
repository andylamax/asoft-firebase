package tz.co.asoft.firebase.firestore.document

import kotlinx.serialization.KSerializer
import tz.co.asoft.firebase.firestore.FirebaseFirestore
import tz.co.asoft.firebase.firestore.collection.CollectionReference
import tz.co.asoft.firebase.firestore.snapshot.DocumentSnapshot

expect class DocumentReference

expect val DocumentReference.firestore: FirebaseFirestore
expect val DocumentReference.id: String
expect fun DocumentReference.collection(path: String): CollectionReference

@Deprecated("use fetch")
expect suspend fun DocumentReference.get(then: suspend (DocumentSnapshot) -> Unit = {})

expect suspend fun <T> DocumentReference.set(data: T, serializer: KSerializer<T>, then: suspend () -> Unit = {})

expect suspend fun <T : Any> DocumentReference.put(data: T, serializer: KSerializer<T>)

expect suspend fun DocumentReference.fetch(): DocumentSnapshot

expect fun DocumentReference.addListener(listener: (DocumentSnapshot) -> Unit)