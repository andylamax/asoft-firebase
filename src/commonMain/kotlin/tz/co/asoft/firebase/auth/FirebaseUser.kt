package tz.co.asoft.firebase.auth

expect abstract class FirebaseUser

expect val FirebaseUser.uid: String
expect val FirebaseUser.email: String?
expect val FirebaseUser.displayName: String?
expect val FirebaseUser.phoneNumber: String?
expect val FirebaseUser.photoURL: String?
expect val FirebaseUser.emailVerified: Boolean
expect val FirebaseUser.isAnonymous: Boolean
expect suspend fun FirebaseUser.remove()
expect suspend fun FirebaseUser.reAuthenticate(credential: AuthCredential)