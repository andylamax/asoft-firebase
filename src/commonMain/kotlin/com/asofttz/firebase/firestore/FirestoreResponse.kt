package com.asofttz.firebase.firestore

expect class FirestoreResponse()

expect suspend fun FirestoreResponse.await() : QuerySnapshot