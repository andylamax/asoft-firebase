package tz.co.asoft.firebase.firestore.snapshot

actual typealias QuerySnapshot = com.google.firebase.firestore.QuerySnapshot

operator fun QuerySnapshot.iterator() = iterator()
actual val QuerySnapshot.docs: Array<QueryDocumentSnapshot> get() = documents.map { it as QueryDocumentSnapshot }.toTypedArray()
actual fun QuerySnapshot.forEach(callback: (QueryDocumentSnapshot) -> Unit) {
    forEach {
        callback(it)
    }
}