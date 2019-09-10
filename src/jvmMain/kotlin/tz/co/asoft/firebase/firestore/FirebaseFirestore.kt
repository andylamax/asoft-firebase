package tz.co.asoft.firebase.firestore

import tz.co.asoft.firebase.core.FirebaseApp
import tz.co.asoft.firebase.firestore.batch.WriteBatch
import tz.co.asoft.firebase.firestore.collection.CollectionReference
import tz.co.asoft.firebase.firestore.document.DocumentReference

actual class FirebaseFirestore

actual val FirebaseFirestore.app: FirebaseApp
    get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

actual fun FirebaseFirestore.collection(path: String): CollectionReference {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}

actual fun FirebaseFirestore.document(path: String): DocumentReference {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}

actual fun FirebaseApp.firestore(): FirebaseFirestore {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}

actual fun FirebaseFirestore.batch(): WriteBatch {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}