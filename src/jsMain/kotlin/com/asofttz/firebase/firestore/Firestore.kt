package com.asofttz.firebase.firestore

import com.asofttz.firebase.app.App

actual external class Firestore {
    actual val app: App

    actual fun collection(path: String): CollectionReference

    @JsName("doc")
    actual fun document(path: String): DocumentReference
}