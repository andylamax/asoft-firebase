package tz.co.asoft.firebase.auth

actual abstract class FirebaseUser

actual val FirebaseUser.uid: String
    get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
actual val FirebaseUser.email: String?
    get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
actual val FirebaseUser.displayName: String?
    get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
actual val FirebaseUser.phoneNumber: String?
    get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
actual val FirebaseUser.photoURL: String?
    get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
actual val FirebaseUser.emailVerified: Boolean
    get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
actual val FirebaseUser.isAnonymous: Boolean
    get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

actual suspend fun FirebaseUser.remove() {
}

actual suspend fun FirebaseUser.reAuthenticate(credential: AuthCredential) {
}