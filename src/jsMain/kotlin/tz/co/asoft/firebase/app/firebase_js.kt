package tz.co.asoft.firebase.app

import tz.co.asoft.firebase.core.FirebaseApp
import tz.co.asoft.firebase.core.FirebaseOptions

/**
 * Exposes the firebase js
 */
@JsModule("firebase/app")
@JsName("default")
external object firebase {
    fun initializeApp(options: FirebaseOptions, name: String? = definedExternally): FirebaseApp
}