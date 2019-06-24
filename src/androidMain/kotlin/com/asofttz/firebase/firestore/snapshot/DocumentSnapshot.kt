package com.asofttz.firebase.firestore.snapshot

import kotlinx.serialization.KSerializer

actual typealias DocumentSnapshot = com.google.firebase.firestore.DocumentSnapshot

actual inline fun <reified T> DocumentSnapshot.toObject(serializer: KSerializer<T>): T? {
    return toObject(T::class.java)
}