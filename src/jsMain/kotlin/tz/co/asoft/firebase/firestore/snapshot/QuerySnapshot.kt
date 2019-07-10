package tz.co.asoft.firebase.firestore.snapshot

actual external class QuerySnapshot {
    val docs: Array<QueryDocumentSnapshot>
    fun forEach(callback: (QueryDocumentSnapshot) -> Unit)
}

actual val QuerySnapshot.docs: Array<QueryDocumentSnapshot> get() = docs
actual fun QuerySnapshot.forEach(callback: (QueryDocumentSnapshot) -> Unit) = forEach {
    callback(it)
}
