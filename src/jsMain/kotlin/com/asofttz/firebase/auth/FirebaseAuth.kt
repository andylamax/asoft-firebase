package com.asofttz.firebase.auth

import com.asofttz.firebase.core.FirebaseApp
import kotlinx.coroutines.await
import kotlin.js.Promise

actual external class FirebaseAuth {
    val app: FirebaseApp
    val currentUser: FirebaseUser?
    fun createUserWithEmailAndPassword(email: String, password: String): Promise<AuthResult>
    fun signInWithEmailAndPassword(email: String, password: String) : Promise<AuthResult>
    fun signOut(): Promise<Unit>
}

actual val FirebaseAuth.app: FirebaseApp get() = app
actual val FirebaseAuth.currentUser get() = currentUser
actual suspend fun FirebaseAuth.createUserWithEmailAndPassword(email: String, password: String, then: (AuthResult) -> Unit) {
    val res = createUserWithEmailAndPassword(email, password).await()
    then(res)
}

actual suspend fun FirebaseAuth.signInWithEmailAndPassword(email: String, password: String, then: (AuthResult) -> Unit) {
    val res = signInWithEmailAndPassword(email, password).await()
    then(res)
}

actual suspend fun FirebaseAuth.signOut() {
    signOut().await()
}

actual fun FirebaseApp.auth(): FirebaseAuth = auth()