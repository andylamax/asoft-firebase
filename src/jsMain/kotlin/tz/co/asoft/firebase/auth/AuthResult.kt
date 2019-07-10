package tz.co.asoft.firebase.auth

actual external interface AuthResult {
    var user: FirebaseUser?
}

actual val AuthResult.user get() = user