package com.asofttz.firebase.firestore

import kotlinx.coroutines.await
import kotlin.js.Promise

actual external class Query {
    fun get(): Promise<QuerySnapshot>
    fun where(field: String, opStr: String, value: Any): Query
    actual fun limit(limit: Number): Query
}

actual suspend fun Query.getAsync(): QuerySnapshot = get().await()