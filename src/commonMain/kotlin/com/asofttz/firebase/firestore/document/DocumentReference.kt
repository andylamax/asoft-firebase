package com.asofttz.firebase.firestore.document

import com.asofttz.firebase.firestore.snapshot.DocumentSnapshot
import com.asofttz.firebase.firestore.FirebaseFirestore
import com.asofttz.firebase.firestore.collection.CollectionReference

expect class DocumentReference

expect val DocumentReference.Firestore: FirebaseFirestore
expect val DocumentReference.id: String
expect fun DocumentReference.col(path: String): CollectionReference
expect suspend fun DocumentReference.get(then: suspend (DocumentSnapshot)->Unit)
expect suspend fun DocumentReference.set(data: Any, then: suspend ()->Unit)