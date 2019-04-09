package com.asofttz.firebase.app

import com.asofttz.firebase.firestore.Firestore

actual interface App {
    actual val name: String
    actual val options: Options
    actual fun firestore(): Firestore
}