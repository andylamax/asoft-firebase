package com.asofttz.firebase.firestore.snapshot

import kotlinx.serialization.KSerializer

actual open class DocumentSnapshot {

}

actual inline fun <T> DocumentSnapshot.toObject(serializer: KSerializer<T>): T? {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}

