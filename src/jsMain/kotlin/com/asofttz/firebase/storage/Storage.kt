package com.asofttz.firebase.storage

import com.asofttz.firebase.app.App

actual external class Storage {
    actual val app: App
    actual fun ref(path: String?) : Reference
}