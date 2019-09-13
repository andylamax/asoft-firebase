package tz.co.asoft.firebase.auth.viewmodel

import tz.co.asoft.auth.User
import tz.co.asoft.firebase.auth.repo.AuthFirebaseAbstractRepo
import tz.co.asoft.firebase.firestore.viewmodel.FirebaseViewModel
import tz.co.asoft.io.file.File
import tz.co.asoft.persist.result.Result
import tz.co.asoft.rx.lifecycle.LifeCycle
import tz.co.asoft.rx.subscriber.Subscriber

open class AuthFirebaseViewModel(private val repo: AuthFirebaseAbstractRepo) : FirebaseViewModel<User>(repo) {
    open suspend fun emailSignIn(email: String, pwd: String) = repo.emailSignIn(email, pwd)

    open suspend fun emailSignInCatching(email: String, pwd: String) = Result.catching { emailSignIn(email, pwd) }

    open suspend fun phoneSignIn(phone: String, pwd: String) = repo.phoneSignIn(phone, pwd)

    open suspend fun phoneSignInCatching(phone: String, pwd: String) = Result.catching { phoneSignIn(phone, pwd) }

    open suspend fun uploadPhoto(user: User, file: File): User? = repo.uploadPhoto(user, file)

    open suspend fun uploadPhotoCatching(user: User, file: File) = Result.catching { uploadPhoto(user, file) }

    open suspend fun signOut(): User? = repo.signOut()

    open suspend fun onAuthStateChanged(handler: (User?) -> Unit): Subscriber<User?> = repo.onAuthStateChanged(handler)

    open suspend fun observeLoggedUser(lifeCycle: LifeCycle, handler: (User?) -> Unit) =
        repo.observeLoggedUser(lifeCycle, handler)
}