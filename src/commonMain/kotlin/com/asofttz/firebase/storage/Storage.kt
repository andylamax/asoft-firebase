package com.asofttz.firebase.storage

import com.asofttz.firebase.core.FirebaseApp

expect class Storage {
    val app: FirebaseApp
    fun ref(path: String?) : Reference
}