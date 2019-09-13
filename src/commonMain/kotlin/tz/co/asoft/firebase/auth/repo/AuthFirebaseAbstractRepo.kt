package tz.co.asoft.firebase.auth.repo

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import tz.co.asoft.auth.User
import tz.co.asoft.auth.dao.AuthAbstractLocalDao
import tz.co.asoft.auth.dao.AuthLocalDao
import tz.co.asoft.auth.exceptions.Exceptions
import tz.co.asoft.firebase.auth.dao.AuthFirebaseAbstractDao
import tz.co.asoft.firebase.firestore.repo.FirebaseRepo
import tz.co.asoft.io.file.File
import tz.co.asoft.persist.result.Result
import tz.co.asoft.persist.tools.Cause
import tz.co.asoft.rx.lifecycle.LifeCycle
import tz.co.asoft.rx.lifecycle.LiveData
import tz.co.asoft.rx.observers.Observable
import tz.co.asoft.rx.subscriber.Subscriber

abstract class AuthFirebaseAbstractRepo(private val dao: AuthFirebaseAbstractDao, private val localDao: AuthAbstractLocalDao) :
        FirebaseRepo<User>(dao) {
    open val loggedUser = LiveData<User?>(null)
    open var currentUser = Observable<User?>(null)

    open suspend fun emailSignIn(email: String, pwd: String) = dao.emailSignIn(email, pwd).also {
        onSignIn(it)
    }

    open suspend fun emailSignInCatching(email: String, pwd: String) = Result.catching { emailSignIn(email, pwd) }

    open suspend fun phoneSignIn(phone: String, pwd: String) = dao.phoneSignIn(phone, pwd).also {
        onSignIn(it)
    }

    open suspend fun phoneSignInCatching(phone: String, pwd: String) = Result.catching { phoneSignIn(phone, pwd) }

    open suspend fun uploadPhoto(user: User, file: File): User? {
        val u = dao.uploadPhoto(user, file) ?: return null
        currentUser.value = u
        localDao.apply {
            signOut()
            save(u)
        }
        return u
    }

    open suspend fun uploadPhotoCatching(user: User, file: File) = Result.catching { uploadPhoto(user, file) }

    open suspend fun onSignIn(user: User?) {
        currentUser.value = user
        loggedUser.value = user
        if (user != null) {
            localDao.save(user)
        }
    }

    open suspend fun signOut(): User? = currentUser.value?.let {
        dao.signOut(it)
        currentUser.value = null
        loggedUser.value = null
        localDao?.signOut()
        it
    }

    open suspend fun onAuthStateChanged(handler: (User?) -> Unit): Subscriber<User?> = coroutineScope {
        if (currentUser.value == null && localDao != null)
            launch { currentUser.value = localDao.load() }
        currentUser.subscribe(handler)
    }

    open suspend fun observeLoggedUser(lifeCycle: LifeCycle, handler: (User?) -> Unit) = coroutineScope {
        if (loggedUser.value == null && localDao != null)
            launch { loggedUser.value = localDao.load() }
        loggedUser.observe(lifeCycle, handler)
    }
}