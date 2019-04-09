@file:JsModule("firebase")

package com.asofttz.firebase.app

@JsName("default")
actual external object firebase {
    actual fun initializeApp(options: Options): App
}