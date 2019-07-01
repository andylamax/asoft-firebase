package com.asofttz.firebase.firestore.query

import com.asofttz.firebase.firestore.snapshot.QuerySnapshot

expect open class Query

expect fun Query.where(fieldPath: String, operator: String, value: Any): Query
expect fun Query.limit(limit: Long): Query

expect suspend fun Query.get(then: suspend (QuerySnapshot) -> Unit)