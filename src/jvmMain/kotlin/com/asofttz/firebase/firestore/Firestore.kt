package com.asofttz.firebase.firestore

import com.asofttz.firebase.core.FirebaseApp
import com.asofttz.firebase.firestore.collection.CollectionReference
import com.asofttz.firebase.firestore.document.DocumentReference

actual class FirebaseFirestore {

}

actual val FirebaseFirestore.app: FirebaseApp
    get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

actual fun FirebaseFirestore.collection(path: String): CollectionReference {
    TODO()
}

actual fun FirebaseFirestore.document(path: String): DocumentReference {
    TODO()
}

actual fun FirebaseApp.firestore(): FirebaseFirestore {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}