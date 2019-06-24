package com.asofttz.firebase.firestore

import com.asofttz.firebase.core.FirebaseApp
import com.asofttz.firebase.firestore.collection.CollectionReference
import com.asofttz.firebase.firestore.document.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore as GFirebaseFirestore

actual typealias FirebaseFirestore = GFirebaseFirestore

actual val FirebaseFirestore.app: FirebaseApp
    get() = app

actual fun FirebaseFirestore.collection(path: String): CollectionReference {
    return collection(path)
}

actual fun FirebaseFirestore.document(path: String): DocumentReference {
    return document(path)
}

actual fun FirebaseApp.firestore(): FirebaseFirestore {
    return GFirebaseFirestore.getInstance(this)
}