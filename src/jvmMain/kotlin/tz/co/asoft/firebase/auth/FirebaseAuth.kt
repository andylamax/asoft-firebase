package tz.co.asoft.firebase.auth

import tz.co.asoft.firebase.core.FirebaseApp

actual class FirebaseAuth

actual val FirebaseAuth.app: FirebaseApp
    get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
actual val FirebaseAuth.currentUser: FirebaseUser?
    get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

actual suspend fun FirebaseAuth.createUserWithEmailAndPassword(
        email: String,
        password: String,
        then: (AuthResult) -> Unit
) {
}

actual suspend fun FirebaseAuth.signInWithEmailAndPassword(
        email: String,
        password: String,
        then: (AuthResult) -> Unit
) {
}

actual suspend fun FirebaseAuth.signOut() {
}

actual fun FirebaseApp.auth(): FirebaseAuth {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}

actual suspend fun FirebaseAuth.makeUserWithEmailAndPassword(email: String, password: String): AuthResult {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}

actual suspend fun FirebaseAuth.loginUserWithEmailAndPassword(email: String, password: String): AuthResult {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}

actual suspend fun FirebaseAuth.logout() {
}