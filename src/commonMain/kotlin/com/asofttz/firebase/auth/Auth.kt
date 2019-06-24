package com.asofttz.firebase.auth

import com.asofttz.firebase.core.FirebaseApp

expect class Auth {
    val app: FirebaseApp
    val currentUser: User
    fun signOut()
}

expect suspend fun Auth.createUserWithEmailAndPasswordAsync(email: String, password: String) : UserCredential