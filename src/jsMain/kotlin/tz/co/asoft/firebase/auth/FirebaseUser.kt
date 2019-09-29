package tz.co.asoft.firebase.auth

import kotlinx.coroutines.await
import kotlin.js.Promise

actual abstract external class FirebaseUser {
    var uid: String
    var email: String?
    var phoneNumber: String?
    var photoURL: String?
    var emailVerified: Boolean
    var isAnonymous: Boolean
    var displayName: String?
    fun delete(): Promise<Unit>
    fun reauthenticateWithCredential(credential: AuthCredential): Promise<dynamic>
}

actual val FirebaseUser.uid get() = uid
actual val FirebaseUser.email get() = email
actual val FirebaseUser.emailVerified get() = emailVerified
actual val FirebaseUser.photoURL get() = photoURL
actual val FirebaseUser.isAnonymous get() = isAnonymous
actual val FirebaseUser.phoneNumber get() = phoneNumber
actual val FirebaseUser.displayName get() = displayName
actual suspend fun FirebaseUser.remove() = delete().await()
actual suspend fun FirebaseUser.reAuthenticate(credential: AuthCredential) {
    reauthenticateWithCredential(credential).unsafeCast<Promise<dynamic>>().await()
}