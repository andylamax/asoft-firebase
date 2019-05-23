package com.asofttz.firebase.firestore

expect class QuerySnapshot {
    val docs : Array<QueryDocumentSnapshot>
    fun forEach(callback: (QueryDocumentSnapshot) -> Unit)
}