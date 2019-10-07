package tz.co.asoft.firebase.core

import tz.co.asoft.firebase.core.FirebaseApp
import tz.co.asoft.firebase.core.FirebaseOptions
import tz.co.asoft.platform.core.Ctx

actual object Firebase {
    actual fun initializeApp(
            ctx: Ctx,
            options: FirebaseOptions,
            name: String?
    ): FirebaseApp {
        TODO("Not implemented in java")
    }
}