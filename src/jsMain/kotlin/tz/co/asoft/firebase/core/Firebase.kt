package tz.co.asoft.firebase.core

import tz.co.asoft.platform.core.Ctx

actual object Firebase {
    actual fun initializeApp(ctx: Ctx, options: FirebaseOptions, name: String?): FirebaseApp {
        return if (name != null) {
            firebase.initializeApp(options, name)
        } else {
            firebase.initializeApp(options)
        }
    }
}