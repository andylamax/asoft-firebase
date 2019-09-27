package tz.co.asoft.firebase.auth.repo

import tz.co.asoft.auth.User
import tz.co.asoft.auth.dao.AuthAbstractDao
import tz.co.asoft.auth.dao.AuthAbstractLocalDao
import tz.co.asoft.firebase.auth.dao.AuthFirebaseAbstractDao
import tz.co.asoft.firebase.firestore.repo.FirebaseRepo
import tz.co.asoft.io.file.File
import tz.co.asoft.persist.repo.Repo

abstract class AuthFirebaseAbstractRepo(
        private val dao: AuthFirebaseAbstractDao,
        private val localDao: AuthAbstractLocalDao?
) : FirebaseRepo<User>(dao) {

    open suspend fun emailSignIn(email: String, pwd: String) = dao.emailSignIn(email, pwd)?.also {
        it.saveToLocalDb()
    }

    open suspend fun phoneSignIn(phone: String, pwd: String) = dao.phoneSignIn(phone, pwd)?.also {
        it.saveToLocalDb()
    }

    open suspend fun uploadPhoto(user: User, photo: File) = dao.uploadPhoto(user, photo)?.also {
        localDao?.delete()
        localDao?.save(it)
    }

    open suspend fun saveToLocal(user: User) = user.saveToLocalDb()

    open suspend fun loadLocalUser() = localDao?.load()

    override suspend fun delete(t: User): User? {
        localDao?.delete()
        return dao.delete(t)
    }

    private suspend fun User.saveToLocalDb() = localDao?.save(this)
}