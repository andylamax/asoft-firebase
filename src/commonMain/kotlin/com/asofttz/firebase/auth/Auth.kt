package com.asofttz.firebase.auth

import com.asofttz.firebase.app.App

expect class Auth {
    val app: App
    val currentUser: User
    fun signOut()
}

expect suspend fun Auth.createUserWithEmailAndPasswordAsync(email: String, password: String) : UserCredential