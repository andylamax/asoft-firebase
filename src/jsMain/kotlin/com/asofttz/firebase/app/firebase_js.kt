package com.asofttz.firebase.app

import com.asofttz.firebase.core.FirebaseApp
import com.asofttz.firebase.core.FirebaseOptions

/**
 * Exposes the firebase js
 */
@JsModule("firebase")
@JsName("default")
external object firebase {
    fun initializeApp(options: FirebaseOptions, name: String? = definedExternally): FirebaseApp
}