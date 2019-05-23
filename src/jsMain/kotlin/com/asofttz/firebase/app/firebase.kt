@file:JsModule("firebase")

// version 5.11.1

package com.asofttz.firebase.app

@JsName("default")
actual external object firebase {
    actual fun initializeApp(options: Options, name: String?): App
}