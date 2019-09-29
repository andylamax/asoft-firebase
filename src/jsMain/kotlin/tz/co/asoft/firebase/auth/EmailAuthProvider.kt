package tz.co.asoft.firebase.auth

external interface IEmailAuthProvider {
    fun credential(email: String, pwd: String): AuthCredential
}

@JsModule("firebase/auth")
@JsName("EmailAuthProvider")
external val FirebaseEmailAuthProvider: IEmailAuthProvider

@JsName("AsoftFirebaseEmailAuthProvider")
actual class EmailAuthProvider {
    actual companion object {
        actual fun getCredential(email: String, pwd: String): AuthCredential {
            return FirebaseEmailAuthProvider.credential(email, pwd)
        }
    }
}