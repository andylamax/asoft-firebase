@file:JvmName("AndroidQuery")

package tz.co.asoft.firebase.firestore.query

import tz.co.asoft.firebase.firestore.snapshot.QuerySnapshot
import tz.co.asoft.firebase.firestore.tools.await

actual typealias Query = com.google.firebase.firestore.Query

actual suspend fun Query.fetch(): QuerySnapshot = get().await()

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
    "array-contains" -> whereArrayContains(fieldPath, value)
    else -> this
}