package com.asofttz.firebase.firestore

actual external class QuerySnapshot {
    actual val docs: Array<QueryDocumentSnapshot>
    actual fun forEach(callback: (QueryDocumentSnapshot)->Unit)
}