package tz.co.asoft.firebase.app

import tz.co.asoft.firebase.core.FirebaseApp
import tz.co.asoft.firebase.core.FirebaseOptions
import tz.co.asoft.platform.Ctx

expect object Firebase {
    fun initializeApp(ctx: Ctx, options: FirebaseOptions, name: String? = null): FirebaseApp
}