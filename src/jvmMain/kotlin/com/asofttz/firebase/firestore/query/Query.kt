package com.asofttz.firebase.firestore.query

import com.asofttz.firebase.firestore.snapshot.QuerySnapshot

actual open class Query {

}

actual suspend fun Query.get(then: suspend (QuerySnapshot) -> Unit){
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}

actual fun Query.where(fieldPath: String, operator: String, value: Any): Query {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}

actual fun Query.limit(limit: Long): Query {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}