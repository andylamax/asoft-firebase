package com.asofttz.firebase.app

@JsName("require")
external fun require(module: String)

actual fun App.use(module: String): App {
    println("Loading: $module")
    val p = try {
        require(module)
    } catch (err: Throwable) {
        println(err.message)
    }
    println(p)
    return this
}