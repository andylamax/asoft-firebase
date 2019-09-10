package tz.co.asoft.firebase.firestore.query

import tz.co.asoft.firebase.firestore.snapshot.QuerySnapshot
import kotlinx.coroutines.await
import kotlin.js.Promise

actual open external class Query {
    open fun get(): Promise<QuerySnapshot>
    fun where(field: String, opStr: String, value: Any): Query
    fun limit(limit: Number): Query
}

actual suspend fun Query.fetch(): QuerySnapshot = get().await()

actual suspend fun Query.get(then: suspend (QuerySnapshot) -> Unit) {
    then(get().await())
}

actual fun Query.where(fieldPath: String, operator: String, value: Any): Query = where(fieldPath, operator, value)

actual fun Query.limit(limit: Long): Query = limit(limit.toInt())