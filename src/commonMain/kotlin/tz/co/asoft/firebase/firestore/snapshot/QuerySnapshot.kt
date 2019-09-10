package tz.co.asoft.firebase.firestore.snapshot

expect class QuerySnapshot

expect val QuerySnapshot.documents: List<QueryDocumentSnapshot>

expect fun QuerySnapshot.forEach(callback: (QueryDocumentSnapshot) -> Unit)