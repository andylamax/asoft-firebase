@file:JvmName("AndroidDocumentSnapshot")

package tz.co.asoft.firebase.firestore.snapshot

import com.google.gson.Gson
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json

actual typealias DocumentSnapshot = com.google.firebase.firestore.DocumentSnapshot

actual fun <T> DocumentSnapshot.toObject(serializer: KSerializer<T>): T? = if (data == null) {
    null
} else {
    Json.nonstrict.parse(serializer, Gson().toJson(data))
}

actual fun DocumentSnapshot.get(fieldPath: String): Any? = get(fieldPath)
actual fun DocumentSnapshot.data(): Map<String, Any>? = data
actual val DocumentSnapshot.id: String
    get() = id