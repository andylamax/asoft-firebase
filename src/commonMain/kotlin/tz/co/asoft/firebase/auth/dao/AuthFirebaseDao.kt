package tz.co.asoft.firebase.auth.dao

import tz.co.asoft.auth.User
import tz.co.asoft.auth.dao.IAuthDao
import tz.co.asoft.auth.exceptions.Exceptions
import tz.co.asoft.firebase.core.FirebaseApp
import tz.co.asoft.firebase.firestore.FirebaseFirestore
import tz.co.asoft.firebase.firestore.dao.FirebaseDao
import tz.co.asoft.firebase.firestore.firestore
import tz.co.asoft.firebase.firestore.query.fetch
import tz.co.asoft.firebase.firestore.query.where
import tz.co.asoft.firebase.firestore.snapshot.documents
import tz.co.asoft.firebase.firestore.snapshot.toObject
import tz.co.asoft.firebase.storage.*
import tz.co.asoft.io.file.File
import tz.co.asoft.persist.dao.Dao
import tz.co.asoft.persist.tools.Cause
import tz.co.asoft.persist.tools.Singleton

class AuthFirebaseDao private constructor(firestore: FirebaseFirestore, private val storage: FirebaseStorage) : FirebaseDao<User>(firestore, "users", User.serializer()), IAuthDao {
    companion object {
        private var instance: Dao<User>? = null
        fun getInstance(firestore: FirebaseFirestore, storage: FirebaseStorage) = instance
                ?: AuthFirebaseDao(firestore, storage).also {
                    instance = it
                }
    }

    suspend fun signIn(method: String, key: String, pwd: String): User? {
        val qs = collection.where("${method}s", "array-contains", key).fetch()
        val user = qs.documents.getOrNull(0)?.toObject(serializer) ?: throw Cause(Exceptions.UserNotFound.name)
        if (user.password == pwd) {
            return user
        } else {
            throw Cause(Exceptions.IncorrectPassword.name)
        }
    }

    override suspend fun emailSignIn(email: String, pwd: String): User? {
        return signIn("email", email, pwd)
    }

    override suspend fun phoneSignIn(phone: String, pwd: String): User? {
        return signIn("phone", phone, pwd)
    }

    override suspend fun uploadPhoto(user: User, photo: File): User? {
        val ref = storage.ref("user_profile_photos/${user.uid}")
        val task = ref.upload(photo)
        task.await()
        user.photoUrl = ref.downloadUrl() ?: return null
        return edit(user)
    }
}