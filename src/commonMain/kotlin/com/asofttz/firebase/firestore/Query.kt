package com.asofttz.firebase.firestore

expect class Query {
    fun limit(limit: Number) : Query
}

expect suspend fun Query.getAsync() : QuerySnapshot