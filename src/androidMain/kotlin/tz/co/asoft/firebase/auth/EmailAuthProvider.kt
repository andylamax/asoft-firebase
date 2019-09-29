package tz.co.asoft.firebase.auth

actual class EmailAuthProvider {
    actual companion object {
        actual fun getCredential(email: String, pwd: String): AuthCredential {
            return com.google.firebase.auth.EmailAuthProvider.getCredential(email, pwd)
        }
    }
}