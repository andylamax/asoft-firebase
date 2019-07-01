package com.asofttz.firebase.firestore.query

import com.asofttz.firebase.firestore.snapshot.QuerySnapshot
import com.asofttz.firebase.firestore.tools.await
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

actual typealias Query = com.google.firebase.firestore.Query

actual suspend fun Query.get(then: suspend (QuerySnapshot) -> Unit) {
    then(get().await())
}

actual fun Query.limit(limit: Long): Query = limit(limit)
actual fun Query.where(fieldPath: String, operator: String, value: Any): Query = when (operator) {
    "<" -> whereLessThan(fieldPath, value)
    "<=" -> whereLessThanOrEqualTo(fieldPath, value)
    "==" -> whereEqualTo(fieldPath, value)
    ">=" -> whereGreaterThanOrEqualTo(fieldPath, value)
    ">" -> whereGreaterThan(fieldPath, value)
    else -> this
}