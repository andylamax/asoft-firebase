package com.asofttz.firebase.firestore.snapshot

import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json

actual open external class DocumentSnapshot {
    val id: String
    fun data(): Any?
}

actual inline fun <reified T> DocumentSnapshot.toObject(serializer: KSerializer<T>): T? {
    val obj = data().unsafeCast<T>() ?: return null
    val json = JSON.stringify(obj)
    return Json.parse(serializer,json)
}