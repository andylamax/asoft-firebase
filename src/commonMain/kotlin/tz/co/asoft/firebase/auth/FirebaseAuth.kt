package tz.co.asoft.firebase.auth

import tz.co.asoft.firebase.core.FirebaseApp

expect class FirebaseAuth

expect val FirebaseAuth.app: FirebaseApp
expect val FirebaseAuth.currentUser: FirebaseUser?

@Deprecated("Use makeUserWithEmailAndPassword")
expect suspend fun FirebaseAuth.createUserWithEmailAndPassword(email: String, password: String, then: (AuthResult) -> Unit = {})

@Deprecated("Use loginWithEmailAndPassword")
expect suspend fun FirebaseAuth.signInWithEmailAndPassword(email: String, password: String, then: (AuthResult) -> Unit = {})


//expect suspend fun FirebaseAuth.signInWithCredential(AuthCredential)
//expect suspend fun FirebaseAuth.signInAnonymously()
//expect suspend fun FirebaseAuth.signInWithCustomToken(String)

expect suspend fun FirebaseAuth.makeUserWithEmailAndPassword(email: String, password: String): AuthResult

expect suspend fun FirebaseAuth.loginUserWithEmailAndPassword(email: String, password: String): AuthResult

@Deprecated("use logout")
expect suspend fun FirebaseAuth.signOut()

expect suspend fun FirebaseAuth.logout()

expect fun FirebaseApp.auth(): FirebaseAuth