package tz.co.asoft.firebase.auth.usecase

import com.soywiz.krypto.SHA256
import kotlinx.coroutines.coroutineScope
import kotlinx.serialization.toUtf8Bytes
import tz.co.asoft.auth.User
import tz.co.asoft.auth.tools.hex.hex
import tz.co.asoft.firebase.auth.repo.AuthFirebaseAbstractRepo
import tz.co.asoft.persist.result.Result
import tz.co.asoft.rx.lifecycle.LiveData

class SignInUseCase(
        private val repo: AuthFirebaseAbstractRepo,
        private val authStateUC: AuthStateUseCase,
        private val updateStatusUC: UpdateStatusUseCase
) {
    enum class SignInType {
        email, phone
    }

    suspend operator fun invoke(loginId: String, pwd: String) = coroutineScope {
        val password = SHA256.digest(pwd.toUtf8Bytes()).hex
        val type = if (loginId.contains("@")) {
            SignInType.email
        } else {
            SignInType.phone
        }
        Result.catching {
            when (type) {
                SignInType.email -> repo.emailSignIn(loginId, password)
                SignInType.phone -> repo.phoneSignIn(loginId, password)
            }?.also {
                updateStatusUC(it, User.Status.SignedIn)
            }
        }.also {
            authStateUC.liveUser.value = it.data
        }
    }
}