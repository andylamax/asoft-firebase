package com.asofttz.firebase.firestore.collection

import com.asofttz.firebase.firestore.document.DocumentReference
import com.asofttz.firebase.firestore.FirebaseFirestore
import com.asofttz.firebase.firestore.query.Query
import com.asofttz.firebase.firestore.snapshot.DocumentSnapshot
import com.asofttz.firebase.firestore.snapshot.QueryDocumentSnapshot
import com.asofttz.firebase.firestore.snapshot.QuerySnapshot
import kotlinx.serialization.KSerializer

expect class CollectionReference : Query

expect val CollectionReference.firestore: FirebaseFirestore
expect val CollectionReference.id: String
expect val CollectionReference.parent: DocumentReference?
expect val CollectionReference.path: String
expect fun CollectionReference.doc(documentPath: String? = null): DocumentReference

expect suspend inline fun <reified T> CollectionReference.add(data: T, serializer: KSerializer<T>,then: suspend (DocumentReference)->Unit)

@Deprecated("Use this only on platform specific")
expect suspend fun CollectionReference.forEachAsync(action: (QueryDocumentSnapshot) -> Unit)