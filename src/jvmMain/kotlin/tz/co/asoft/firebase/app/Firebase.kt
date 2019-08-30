package tz.co.asoft.firebase.app

import tz.co.asoft.firebase.core.FirebaseApp
import tz.co.asoft.firebase.core.FirebaseOptions

actual object Firebase {
    actual fun initializeApp(
        context: Any,
        options: FirebaseOptions,
        name: String?
    ): FirebaseApp? {
        return null
    }
}