package tz.co.asoft.firebase.firestore.query

import tz.co.asoft.firebase.firestore.snapshot.QuerySnapshot

expect open class Query

expect fun Query.where(fieldPath: String, operator: String, value: Any): Query

expect fun Query.limit(limit: Long): Query

@Deprecated("Use fetch")
expect suspend fun Query.get(then: suspend (QuerySnapshot) -> Unit)

expect suspend fun Query.fetch(): QuerySnapshot