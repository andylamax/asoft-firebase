package tz.co.asoft.firebase.auth.usecase

import tz.co.asoft.auth.Email
import tz.co.asoft.auth.repo.IUsersRepo
import tz.co.asoft.auth.usecase.deleteuser.IDeleteUserUseCase
import tz.co.asoft.firebase.auth.FirebaseAuth
import tz.co.asoft.firebase.auth.currentUser
import tz.co.asoft.firebase.auth.loginUserWithEmailAndPassword
import tz.co.asoft.firebase.auth.remove
import tz.co.asoft.persist.result.catching
import tz.co.asoft.persist.tools.Cause

class DeleteUserUseCase(
        private val auth: FirebaseAuth,
        private val repo: IUsersRepo
) : IDeleteUserUseCase {
    override suspend fun invoke(email: String, pwd: String) = catching {
        auth.loginUserWithEmailAndPassword(email, pwd)
        auth.currentUser?.remove()
        val user = repo.load(Email(email), pwd) ?: throw Cause("Can't Delete User")
        repo.delete(user)
    }
}