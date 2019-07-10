package tz.co.asoft.firebase.auth

actual abstract external class FirebaseUser {
    var uid: String
    var email: String?
    var phoneNumber: String?
    var photoURL: String?
    var emailVerified: Boolean
    var isAnonymous : Boolean
    var displayName: String?
}

actual val FirebaseUser.uid get() = uid
actual val FirebaseUser.email get() = email
actual val FirebaseUser.emailVerified get() = emailVerified
actual val FirebaseUser.photoURL get() = photoURL
actual val FirebaseUser.isAnonymous get() = isAnonymous
actual val FirebaseUser.phoneNumber get() = phoneNumber
actual val FirebaseUser.displayName get() = displayName