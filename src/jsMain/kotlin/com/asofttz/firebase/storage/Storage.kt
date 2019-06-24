package com.asofttz.firebase.storage

import com.asofttz.firebase.core.FirebaseApp

actual external class Storage {
    actual val app: FirebaseApp
    actual fun ref(path: String?) : Reference
}