package tz.co.asoft.firebase.auth.dao

import com.soywiz.klock.DateTime
import com.soywiz.krypto.SHA256
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.serialization.KSerializer
import kotlinx.serialization.toUtf8Bytes
import tz.co.asoft.auth.User
import tz.co.asoft.auth.exceptions.Exceptions
import tz.co.asoft.auth.tools.hex.hex
import tz.co.asoft.firebase.auth.*
import tz.co.asoft.firebase.core.FirebaseApp
import tz.co.asoft.firebase.firestore.firestore
import tz.co.asoft.firebase.firestore.query.fetch
import tz.co.asoft.firebase.firestore.query.where
import tz.co.asoft.firebase.firestore.snapshot.documents
import tz.co.asoft.firebase.firestore.snapshot.toObject
import tz.co.asoft.firebase.storage.*
import tz.co.asoft.io.file.File
import tz.co.asoft.persist.tools.Cause

class AuthFirebaseDao private constructor(
        val firebase: FirebaseApp,
        override val serializer: KSerializer<User>
) : AuthFirebaseAbstractDao(firebase.firestore(), "users", serializer) {

    companion object {
        private var instance: AuthFirebaseAbstractDao? = null
        fun getInstance(
                firebase: FirebaseApp,
                serializer: KSerializer<User>
        ): AuthFirebaseAbstractDao = instance ?: AuthFirebaseDao(firebase, serializer).also {
            instance = it
        }
    }

    val app by lazy { firebase }

    override suspend fun create(list: List<User>): List<User>? {
        list.forEach {
            val auth = app.auth()
            val res = auth.makeUserWithEmailAndPassword(it.emails[0], it.password).user
                    ?: throw Cause("Couldn't create an account for you. Try again")
            it.uid = res.uid
            auth.logout()
            it.password = SHA256.digest(it.password.toUtf8Bytes()).hex
        }
        return super.create(list)
    }

    private suspend fun signIn(method: String, key: String, pwd: String): User? {
        val password = SHA256.digest(pwd.toUtf8Bytes()).hex
        val qs = collection.where("${method}s", "array-contains", key).fetch()
        val user = qs.documents.getOrNull(0)?.toObject(serializer) ?: throw Cause(Exceptions.UserNotFound.name)
        if (user.password == password) {
            user.lastSeen = DateTime.nowUnixLong()
            user.status = User.Status.SignedIn.name
            return edit(user)
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

    override suspend fun signOut(user: User): User? = coroutineScope {
        user.lastSeen = DateTime.nowUnixLong()
        user.status = User.Status.SignedOut.name
        launch { edit(user) }
        user
    }

    override suspend fun uploadPhoto(user: User, file: File): User? {
        val ref = app.storage().ref("user_profile_photos/${user.uid}")
        val task = ref.put(file)
        task.await()
        user.photoUrl = ref.downloadUrl() ?: return null
        return edit(user)
    }
}