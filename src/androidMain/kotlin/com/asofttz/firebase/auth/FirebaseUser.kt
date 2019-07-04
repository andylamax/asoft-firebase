package com.asofttz.firebase.auth

import com.google.firebase.auth.FirebaseUser as GFirebaseUser

actual typealias FirebaseUser = GFirebaseUser

actual val FirebaseUser.uid get() = uid
actual val FirebaseUser.email get() = email
actual val FirebaseUser.displayName get() = displayName
actual val FirebaseUser.phoneNumber get() = phoneNumber
actual val FirebaseUser.photoURL get() = photoUrl?.toString()
actual val FirebaseUser.emailVerified get() = isEmailVerified
actual val FirebaseUser.isAnonymous get() = isAnonymous