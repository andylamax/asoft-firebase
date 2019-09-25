package tz.co.asoft.firebase.auth.dao

import kotlinx.serialization.KSerializer
import tz.co.asoft.auth.User
import tz.co.asoft.firebase.firestore.FirebaseFirestore
import tz.co.asoft.firebase.firestore.dao.FirebaseDao
import tz.co.asoft.io.file.File

abstract class AuthFirebaseAbstractDao(override val firestore: FirebaseFirestore) : FirebaseDao<User>(firestore, "users", User.serializer()) {
    abstract suspend fun uploadPhoto(user: User, file: File): User?
    abstract suspend fun emailSignIn(email: String, pwd: String): User?
    abstract suspend fun phoneSignIn(phone: String, pwd: String): User?
    abstract suspend fun signOut(user: User): User?
}