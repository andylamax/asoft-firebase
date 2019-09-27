package tz.co.asoft.firebase.auth.usecase

import com.soywiz.krypto.SHA256
import kotlinx.serialization.toUtf8Bytes
import tz.co.asoft.auth.User
import tz.co.asoft.auth.tools.hex.hex
import tz.co.asoft.firebase.auth.*
import tz.co.asoft.firebase.auth.repo.AuthFirebaseAbstractRepo
import tz.co.asoft.persist.result.Result
import tz.co.asoft.persist.tools.Cause

class RegisterUserUseCase(
        private val auth: FirebaseAuth,
        private val repo: AuthFirebaseAbstractRepo,
        private val signInUC: SignInUseCase
) {
    suspend operator fun invoke(u: User) = Result.catching {
        val pwd = u.password
        val res = auth.makeUserWithEmailAndPassword(u.emails.elementAt(0), u.password).user ?: throw cause(u)
        u.uid = res.uid
        auth.logout()
        u.password = SHA256.digest(u.password.toUtf8Bytes()).hex
        repo.create(u) ?: throw Cause("Failed to store ${u.name}'s info")
        signInUC(u.emails.first(), pwd)
    }

    private fun cause(u: User) = Cause("Couldn't create an account for ${u.name}. Try again")
}