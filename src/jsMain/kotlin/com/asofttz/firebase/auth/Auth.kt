package com.asofttz.firebase.auth

import com.asofttz.firebase.app.App
import kotlinx.coroutines.await
import kotlin.js.Promise

actual external class Auth {
    actual val app: App
    actual val currentUser: User
    fun createUserWithEmailAndPassword(email: String, password: String): Promise<UserCredential>
    actual fun signOut(): dynamic
}

actual suspend fun Auth.createUserWithEmailAndPasswordAsync(email: String, password: String): UserCredential {
    return createUserWithEmailAndPassword(email, password).await()
}