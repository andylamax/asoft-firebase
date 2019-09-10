package tz.co.asoft.firebase.firestore.query

import tz.co.asoft.firebase.firestore.snapshot.QuerySnapshot

actual open class Query

actual fun Query.where(
    fieldPath: String,
    operator: String,
    value: Any
): Query {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}

actual fun Query.limit(limit: Long): Query {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}

actual suspend fun Query.get(then: suspend (QuerySnapshot) -> Unit) {
}

actual suspend fun Query.fetch(): QuerySnapshot = TODO()