package com.asofttz.firebase.firestore

import com.asofttz.firebase.core.FirebaseApp
import com.asofttz.firebase.firestore.collection.CollectionReference
import com.asofttz.firebase.firestore.document.DocumentReference


actual external class FirebaseFirestore {
    val app: FirebaseApp

    fun collection(path: String): CollectionReference

    @JsName("doc")
    fun document(path: String): DocumentReference
}

actual val FirebaseFirestore.app: FirebaseApp
    get() = app

actual fun FirebaseFirestore.collection(path: String): CollectionReference {
    return collection(path)
}

actual fun FirebaseFirestore.document(path: String): DocumentReference {
    return document(path) as DocumentReference
}

actual fun FirebaseApp.firestore(): FirebaseFirestore = firestore()