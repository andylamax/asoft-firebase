package tz.co.asoft.firebase.auth.usecase

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import tz.co.asoft.auth.User
import tz.co.asoft.firebase.auth.repo.AuthFirebaseAbstractRepo

class SignOutUseCase(
        private val authStateUC: AuthStateUseCase,
        private val updateStatusUC: UpdateStatusUseCase
) {

    suspend operator fun invoke() = coroutineScope {
        val user = authStateUC.liveUser.value ?: return@coroutineScope
        authStateUC.liveUser.value = null
        launch { updateStatusUC(user, User.Status.SignedOut) }
    }
}