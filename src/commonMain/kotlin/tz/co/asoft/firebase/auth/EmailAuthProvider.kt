package tz.co.asoft.firebase.auth

expect class EmailAuthProvider {
    companion object {
        fun getCredential(email: String, pwd: String): AuthCredential
    }
}