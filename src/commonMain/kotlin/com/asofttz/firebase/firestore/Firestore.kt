package com.asofttz.firebase.firestore

import com.asofttz.firebase.app.App
import kotlin.js.JsName

expect class Firestore {
    val app: App
    fun collection(path: String): CollectionReference
    @JsName("doc")
    fun document(path: String): CollectionReference
}