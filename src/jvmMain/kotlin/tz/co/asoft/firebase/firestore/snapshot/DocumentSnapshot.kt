@file:JvmName("JVMDocumentSnapshot")

package tz.co.asoft.firebase.firestore.snapshot

import kotlinx.serialization.KSerializer

actual open class DocumentSnapshot {

}

actual val DocumentSnapshot.id: String
    get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

actual fun <T> DocumentSnapshot.toObject(serializer: KSerializer<T>): T? {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}

actual fun DocumentSnapshot.get(fieldPath: String): Any? {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}

actual fun DocumentSnapshot.data(): Map<String, Any>? {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}