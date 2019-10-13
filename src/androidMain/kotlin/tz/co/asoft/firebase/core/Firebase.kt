package tz.co.asoft.firebase.core

import tz.co.asoft.platform.core.Ctx
import com.google.firebase.FirebaseApp as GFirebaseApp

actual object Firebase {
    actual fun initializeApp(ctx: Ctx, options: FirebaseOptions, name: String?): FirebaseApp {
        return if (name != null) {
            GFirebaseApp.initializeApp(ctx, options, name)
        } else {
            GFirebaseApp.getApps(ctx).firstOrNull() ?: GFirebaseApp.initializeApp(ctx, options)
        }
    }
}