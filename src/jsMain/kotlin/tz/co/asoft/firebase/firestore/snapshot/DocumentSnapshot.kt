package tz.co.asoft.firebase.firestore.snapshot

import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json

actual open external class DocumentSnapshot {
    val id: String
    fun data(): Map<String,Any>?
    fun get(fieldPath: String) : Any?
}

actual inline fun <reified T> DocumentSnapshot.toObject(serializer: KSerializer<T>): T? {
    val obj = data().unsafeCast<T>() ?: return null
    val json = JSON.stringify(obj)
    return Json.nonstrict.parse(serializer,json)
}

actual fun DocumentSnapshot.get(fieldPath: String): Any? = get(fieldPath)
actual fun DocumentSnapshot.data(): Map<String, Any>? = data()
actual val DocumentSnapshot.id: String
    get() = id