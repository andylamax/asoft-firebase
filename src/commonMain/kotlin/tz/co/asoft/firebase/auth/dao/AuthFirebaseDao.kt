package tz.co.asoft.firebase.auth.dao

import tz.co.asoft.auth.User
import tz.co.asoft.auth.exceptions.Exceptions
import tz.co.asoft.firebase.core.FirebaseApp
import tz.co.asoft.firebase.firestore.firestore
import tz.co.asoft.firebase.firestore.query.fetch
import tz.co.asoft.firebase.firestore.query.where
import tz.co.asoft.firebase.firestore.snapshot.documents
import tz.co.asoft.firebase.firestore.snapshot.toObject
import tz.co.asoft.firebase.storage.*
import tz.co.asoft.io.file.File
import tz.co.asoft.persist.tools.Cause

class AuthFirebaseDao private constructor(val firebase: FirebaseApp) : AuthFirebaseAbstractDao(firebase.firestore()) {

    companion object {
        private var instance: AuthFirebaseAbstractDao? = null
        fun getInstance(
                firebase: FirebaseApp
        ): AuthFirebaseAbstractDao = instance ?: AuthFirebaseDao(firebase).also {
            instance = it
        }
    }

    val app by lazy { firebase }

    private suspend fun signIn(method: String, key: String, pwd: String): User? {
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

    override suspend fun uploadPhoto(user: User, file: File): User? {
        val ref = app.storage().ref("user_profile_photos/${user.uid}")
        val task = ref.upload(file)
        task.await()
        user.photoUrl = ref.downloadUrl() ?: return null
        return edit(user)
    }
}