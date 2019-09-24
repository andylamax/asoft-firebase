package tz.co.asoft.firebase.app

import tz.co.asoft.firebase.core.FirebaseApp
import tz.co.asoft.firebase.core.FirebaseOptions
import tz.co.asoft.platform.Ctx
import com.google.firebase.FirebaseApp as GFirebaseApp

actual object Firebase {
    actual fun initializeApp(ctx: Ctx, options: FirebaseOptions, name: String?): FirebaseApp {
        return if (name != null) {
            GFirebaseApp.initializeApp(ctx, options, name)
        } else {
            GFirebaseApp.initializeApp(ctx, options)
        }
    }
}