package tz.co.asoft.firebase.firestore.document

import tz.co.asoft.firebase.firestore.snapshot.DocumentSnapshot
import tz.co.asoft.firebase.firestore.FirebaseFirestore
import tz.co.asoft.firebase.firestore.collection.CollectionReference
import kotlinx.serialization.KSerializer

expect class DocumentReference

expect val DocumentReference.Firestore: FirebaseFirestore
expect val DocumentReference.id: String
expect fun DocumentReference.collection(path: String): CollectionReference
expect suspend fun DocumentReference.get(then: suspend (DocumentSnapshot)->Unit)
expect suspend fun <T> DocumentReference.set(data: T, serializer: KSerializer<T>,then: suspend ()->Unit = {})