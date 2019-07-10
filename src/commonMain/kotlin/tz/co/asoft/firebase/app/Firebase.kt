package tz.co.asoft.firebase.app

import tz.co.asoft.firebase.core.FirebaseApp
import tz.co.asoft.firebase.core.FirebaseOptions

expect object Firebase {
    fun initializeApp(context: Any, options: FirebaseOptions,name: String? = null) : FirebaseApp?
}