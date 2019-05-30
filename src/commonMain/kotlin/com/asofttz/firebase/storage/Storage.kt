package com.asofttz.firebase.storage

import com.asofttz.firebase.app.App

expect class Storage {
    val app: App
    fun ref(path: String?) : Reference
}