package tz.co.asoft.firebase.auth.viewmodel

import tz.co.asoft.auth.User
import tz.co.asoft.firebase.auth.repo.AuthFirebaseAbstractRepo
import tz.co.asoft.firebase.auth.usecase.*
import tz.co.asoft.firebase.firestore.viewmodel.FirebaseViewModel
import tz.co.asoft.io.file.File
import tz.co.asoft.persist.result.Result
import tz.co.asoft.rx.lifecycle.LifeCycle
import tz.co.asoft.rx.subscriber.Subscriber

open class AuthFirebaseViewModel(
        repo: AuthFirebaseAbstractRepo,
        private val registerUserUC: RegisterUserUseCase,
        private val signInUC: SignInUseCase,
        private val authStateUC: AuthStateUseCase,
        private val signOutUC: SignOutUseCase,
        private val uploadPhotoUC: UploadPhotoUseCase
) : FirebaseViewModel<User>(repo) {
    open suspend fun registerUser(u: User) = registerUserUC(u)

    open suspend fun signIn(loginId: String, pwd: String) = signInUC(loginId, pwd)

    open suspend fun uploadPhoto(user: User, file: File) = uploadPhotoUC(user, file)

    open suspend fun signOut() = signOutUC()

    open suspend fun onAuthStateChanged(lifeCycle: LifeCycle, handler: (User?) -> Unit) = authStateUC.onAuthStateChanged(lifeCycle, handler)
}