package tz.co.asoft.firebase.app

import android.content.Context
import tz.co.asoft.firebase.core.FirebaseApp
import tz.co.asoft.firebase.core.FirebaseOptions
import com.google.firebase.FirebaseApp as GFirebaseApp

actual object Firebase {
    actual fun initializeApp(context: Any, options: FirebaseOptions, name: String?): FirebaseApp? {
        return if (context is Context) {
            if (name != null) {
                GFirebaseApp.initializeApp(context, options, name)
            } else {
                GFirebaseApp.initializeApp(context, options)
            }
        } else {
            null
        }
    }
}