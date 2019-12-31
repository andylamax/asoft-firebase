package tz.co.asoft.firebase.firestore.snapshot

import kotlinx.serialization.ImplicitReflectionSerializer
import kotlinx.serialization.KSerializer
import kotlinx.serialization.serializer

expect open class DocumentSnapshot

expect val DocumentSnapshot.id: String
expect fun <T> DocumentSnapshot.toObject(serializer: KSerializer<T>): T?

@ImplicitReflectionSerializer
inline fun <reified T : Any> DocumentSnapshot.toObject(): T? = toObject(T::class.serializer())

expect fun DocumentSnapshot.get(fieldPath: String): Any?
expect fun DocumentSnapshot.data(): Map<String, Any>?