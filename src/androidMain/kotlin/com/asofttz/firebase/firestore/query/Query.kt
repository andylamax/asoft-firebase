package com.asofttz.firebase.firestore.query

import com.asofttz.firebase.firestore.snapshot.QuerySnapshot
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

actual typealias Query = com.google.firebase.firestore.Query

actual suspend fun Query.get(): QuerySnapshot = suspendCancellableCoroutine { cont ->
    val task = get()
    task.addOnSuccessListener { cont.resume(it) }
    task.addOnFailureListener { cont.cancel(it) }
}