package com.asofttz.firebase.app

import com.asofttz.firebase.core.FirebaseApp
import com.asofttz.firebase.core.FirebaseOptions

expect object Firebase {
    fun initializeApp(context: Any, options: FirebaseOptions,name: String? = null) : FirebaseApp?
}