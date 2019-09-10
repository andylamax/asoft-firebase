package tz.co.asoft.firebase.firestore.snapshot

actual external class QuerySnapshot {
    val docs: Array<QueryDocumentSnapshot>
    fun forEach(callback: (QueryDocumentSnapshot) -> Unit)
}

actual val QuerySnapshot.documents: List<QueryDocumentSnapshot> get() = docs.toList()

actual fun QuerySnapshot.forEach(callback: (QueryDocumentSnapshot) -> Unit) = forEach(callback)
