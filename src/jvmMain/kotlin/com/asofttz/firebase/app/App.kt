package com.asofttz.firebase.app

import com.asofttz.firebase.auth.Auth
import com.asofttz.firebase.firestore.Firestore
import com.asofttz.firebase.storage.Storage

actual interface App {
    actual val name: String
    actual val options: Options
    actual fun firestore(): Firestore
    actual fun auth(): Auth
    actual fun storage(): Storage
}