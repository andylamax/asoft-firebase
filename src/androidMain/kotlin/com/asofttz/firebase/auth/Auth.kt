package com.asofttz.firebase.auth

import com.google.firebase.FirebaseApp

actual class Auth {
    actual val app: FirebaseApp
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    actual val currentUser: User
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    actual fun signOut() {
    }
}

actual suspend fun Auth.createUserWithEmailAndPasswordAsync(email: String, password: String): UserCredential {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}