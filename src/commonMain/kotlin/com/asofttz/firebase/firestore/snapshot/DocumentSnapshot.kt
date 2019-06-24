package com.asofttz.firebase.firestore.snapshot

import kotlinx.serialization.KSerializer

expect open class DocumentSnapshot {

}

expect inline fun <reified T> DocumentSnapshot.toObject(serializer: KSerializer<T>): T?