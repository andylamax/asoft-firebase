package tz.co.asoft.firebase.auth.usecase

import com.soywiz.krypto.SHA256
import kotlinx.serialization.toUtf8Bytes
import tz.co.asoft.auth.User
import tz.co.asoft.auth.tools.hex.hex
import tz.co.asoft.auth.usecase.IRegisterUserUseCase
import tz.co.asoft.auth.usecase.SignInUseCase
import tz.co.asoft.firebase.auth.*
import tz.co.asoft.persist.repo.Repo
import tz.co.asoft.persist.result.Result
import tz.co.asoft.persist.tools.Cause

class RegisterUserUseCase(
        private val auth: FirebaseAuth,
        private val repo: Repo<User>,
        private val signInUC: SignInUseCase
) : IRegisterUserUseCase {
    override suspend operator fun invoke(user: User): Result<User> {
        val pwd = user.password
        val res = auth.makeUserWithEmailAndPassword(user.emails.elementAt(0), user.password).user ?: throw cause(user)
        user.uid = res.uid
        auth.logout()
        user.password = SHA256.digest(user.password.toUtf8Bytes()).hex
        repo.create(user) ?: throw Cause("Failed to store ${user.name}'s info")
        return signInUC(user.emails.first(), pwd)
    }

    private fun cause(u: User) = Cause("Couldn't create an account for ${u.name}. Try again")
}