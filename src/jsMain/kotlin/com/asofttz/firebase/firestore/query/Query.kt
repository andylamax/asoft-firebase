package com.asofttz.firebase.firestore.query

import com.asofttz.firebase.firestore.snapshot.QuerySnapshot
import kotlinx.coroutines.await
import kotlin.js.Promise

actual open external class Query {
    open fun get(): Promise<QuerySnapshot>
    fun where(field: String, opStr: String, value: Any): Query
    actual fun limit(limit: Long): Query
}

actual suspend fun Query.get(): QuerySnapshot = get().await().unsafeCast<QuerySnapshot>()