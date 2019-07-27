package tz.co.asoft.firebase.firestore.snapshot

import kotlinx.serialization.KSerializer

expect open class DocumentSnapshot {

}

expect val DocumentSnapshot.id : String
expect fun <T> DocumentSnapshot.toObject(serializer: KSerializer<T>): T?
expect fun DocumentSnapshot.get(fieldPath: String) : Any?
expect fun DocumentSnapshot.data(): Map<String,Any>?