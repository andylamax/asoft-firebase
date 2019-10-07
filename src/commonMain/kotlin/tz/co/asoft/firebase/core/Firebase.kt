package tz.co.asoft.firebase.core

import tz.co.asoft.platform.core.Ctx

expect object Firebase {
    fun initializeApp(ctx: Ctx, options: FirebaseOptions, name: String? = null): FirebaseApp
}