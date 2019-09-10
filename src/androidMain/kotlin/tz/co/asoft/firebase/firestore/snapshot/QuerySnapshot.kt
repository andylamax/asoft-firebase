@file:JvmName("QuerySnapshotAndroid")

package tz.co.asoft.firebase.firestore.snapshot

actual typealias QuerySnapshot = com.google.firebase.firestore.QuerySnapshot

operator fun QuerySnapshot.iterator() = iterator()

actual val QuerySnapshot.documents: List<QueryDocumentSnapshot> get() = documents.map { it as QueryDocumentSnapshot }

actual fun QuerySnapshot.forEach(callback: (QueryDocumentSnapshot) -> Unit) {
    forEach {
        callback(it)
    }
}