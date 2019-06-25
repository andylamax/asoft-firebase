package com.asofttz.firebase.firestore.snapshot

import com.google.gson.Gson
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json

actual typealias DocumentSnapshot = com.google.firebase.firestore.DocumentSnapshot

actual inline fun <reified T> DocumentSnapshot.toObject(serializer: KSerializer<T>): T? {
    val obj = data ?: return null
    return Json.parse(serializer, Gson().toJson(obj))
}

actual fun DocumentSnapshot.get(fieldPath: String): Any? = get(fieldPath)
actual fun DocumentSnapshot.data(): Map<String, Any>? = data