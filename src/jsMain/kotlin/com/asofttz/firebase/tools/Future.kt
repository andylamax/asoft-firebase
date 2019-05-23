package com.asofttz.firebase.tools

import kotlin.js.Promise

actual class Future<T> constructor() {
    lateinit var promise: Promise<T>

    constructor(promise: Promise<T>) : this() {
        this.promise = promise
    }
}