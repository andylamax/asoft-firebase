package tz.co.asoft.firebase.auth.usecase

import tz.co.asoft.auth.Email
import tz.co.asoft.auth.User
import tz.co.asoft.auth.repo.IAuthRepo
import tz.co.asoft.auth.usecase.deleteuser.IDeleteUserUseCase
import tz.co.asoft.firebase.auth.*
import tz.co.asoft.persist.repo.Repo
import tz.co.asoft.persist.result.Result
import tz.co.asoft.persist.tools.Cause

class DeleteUserUseCase(
        private val auth: FirebaseAuth,
        private val repo: Repo<User>
) : IDeleteUserUseCase {

    override suspend fun invoke(email: String, pwd: String): Result<User> = try {
        auth.loginUserWithEmailAndPassword(email, pwd)
        auth.currentUser?.remove()
        Result.catching { auth.logout() }
        if (repo is IAuthRepo) {
            Result.catching {
                val user = repo.load(Email(email), pwd) ?: throw Cause("User not found in d.b")
                repo.delete(user)
            }
        } else throw Cause("Can't delete user from a non IAuthRepo")
    } catch (c: Cause) {
        Result.failure(c)
    }
}