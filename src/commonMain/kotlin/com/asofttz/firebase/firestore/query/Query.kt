package com.asofttz.firebase.firestore.query

import com.asofttz.firebase.firestore.snapshot.QuerySnapshot

expect open class Query {
    fun limit(limit: Long) : Query
}

expect suspend fun Query.get() : QuerySnapshot