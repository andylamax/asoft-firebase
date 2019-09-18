package tz.co.asoft.firebase.firestore.collection

import tz.co.asoft.firebase.firestore.document.DocumentReference
import tz.co.asoft.firebase.firestore.FirebaseFirestore
import tz.co.asoft.firebase.firestore.query.Query
import tz.co.asoft.firebase.firestore.snapshot.QueryDocumentSnapshot
import kotlinx.serialization.KSerializer
import tz.co.asoft.firebase.firestore.snapshot.QuerySnapshot

expect class CollectionReference : Query

expect val CollectionReference.firestore: FirebaseFirestore
expect val CollectionReference.id: String
expect val CollectionReference.parent: DocumentReference?
expect val CollectionReference.path: String
expect fun CollectionReference.doc(documentPath: String? = null): DocumentReference
expect fun CollectionReference.addListener(listener: (QuerySnapshot) -> Unit)

@Deprecated("Use upload")
expect suspend fun <T> CollectionReference.add(
    data: T,
    serializer: KSerializer<T>,
    then: suspend (DocumentReference) -> Unit
)

expect suspend fun <T : Any> CollectionReference.put(data: T, serializer: KSerializer<T>): DocumentReference

@Deprecated("Use this only on platform specific")
expect suspend fun CollectionReference.forEachAsync(action: (QueryDocumentSnapshot) -> Unit)