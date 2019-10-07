package tz.co.asoft.firebase.core

/**
 * Exposes the firebase js
 */
@JsModule("firebase/app")
@JsName("default")
external object firebase {
    fun initializeApp(options: FirebaseOptions, name: String? = definedExternally): FirebaseApp
}