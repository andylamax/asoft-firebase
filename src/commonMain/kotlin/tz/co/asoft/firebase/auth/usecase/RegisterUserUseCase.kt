package tz.co.asoft.firebase.auth.usecase

import com.soywiz.krypto.SHA256
import kotlinx.serialization.toUtf8Bytes
import tz.co.asoft.auth.User
import tz.co.asoft.auth.UserAccount
import tz.co.asoft.auth.tools.hex.hex
import tz.co.asoft.auth.usecase.registeruser.IRegisterUserUseCase
import tz.co.asoft.firebase.auth.*
import tz.co.asoft.persist.repo.IRepo
import tz.co.asoft.persist.result.catching
import tz.co.asoft.persist.tools.Cause

class RegisterUserUseCase(
        private val auth: FirebaseAuth,
        private val usersRepo: IRepo<User>,
        private val accountsRepo: IRepo<UserAccount>
) : IRegisterUserUseCase {
    override suspend operator fun invoke(user: User, ua: UserAccount?) = catching {
        val acc = ua ?: UserAccount().apply {
            name = user.name
            permits = user.permits
        }
        val account = accountsRepo.createCatching(acc).respond()
        user.accounts.add(account)
        val pwd = user.password ?: throw Cause("Make sure user has a valid password")
        val res = auth.makeUserWithEmailAndPassword(user.emails.first(), pwd).user ?: throw cause(user)
        user.uid = res.uid
        auth.logout()
        user.password = SHA256.digest(pwd.toUtf8Bytes()).hex
        usersRepo.create(user)
    }

    private fun cause(u: User) = Cause("Couldn't create an account for ${u.name}. Try again")
}