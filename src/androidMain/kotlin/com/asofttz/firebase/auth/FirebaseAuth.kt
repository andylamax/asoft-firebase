package com.asofttz.firebase.auth

import com.asofttz.firebase.core.FirebaseApp
import com.asofttz.firebase.firestore.tools.await
import com.google.firebase.auth.FirebaseAuth as GFirebaseAuth

actual typealias FirebaseAuth = GFirebaseAuth

actual val FirebaseAuth.app get() = app
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
    signOut()
}

actual fun FirebaseApp.auth(): FirebaseAuth = FirebaseAuth.getInstance(this)