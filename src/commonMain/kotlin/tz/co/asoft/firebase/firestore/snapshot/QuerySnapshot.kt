package tz.co.asoft.firebase.firestore.snapshot

import kotlinx.serialization.ImplicitReflectionSerializer
import kotlinx.serialization.KSerializer

expect class QuerySnapshot

expect val QuerySnapshot.documents: List<QueryDocumentSnapshot>

expect fun QuerySnapshot.forEach(callback: (QueryDocumentSnapshot) -> Unit)

fun <T : Any> QuerySnapshot.toObjects(serializer: KSerializer<T>): List<T> =
        documents.mapNotNull { it.toObject(serializer) }

@ImplicitReflectionSerializer
inline fun <reified T : Any> QuerySnapshot.toObjects(): List<T> =
        documents.mapNotNull { it.toObject<T>() }