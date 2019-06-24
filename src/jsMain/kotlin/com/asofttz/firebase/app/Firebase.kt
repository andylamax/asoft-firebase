package com.asofttz.firebase.app

import com.asofttz.firebase.core.FirebaseApp
import com.asofttz.firebase.core.FirebaseOptions

actual object Firebase {
    actual fun initializeApp(context: Any, options: FirebaseOptions, name: String?): FirebaseApp? {
        return if (name != null) {
            firebase.initializeApp(options, name)
        } else {
            firebase.initializeApp(options)
        }
    }
}