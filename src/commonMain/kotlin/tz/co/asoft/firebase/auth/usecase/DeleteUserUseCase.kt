package tz.co.asoft.firebase.auth.usecase

import tz.co.asoft.auth.User
import tz.co.asoft.auth.repo.IAuthRepo
import tz.co.asoft.auth.usecase.deleteuser.IDeleteUserUseCase
import tz.co.asoft.auth.usecase.loaduser.ILoadUserUseCase
import tz.co.asoft.firebase.auth.FirebaseAuth
import tz.co.asoft.firebase.auth.currentUser
import tz.co.asoft.firebase.auth.loginUserWithEmailAndPassword
import tz.co.asoft.firebase.auth.remove
import tz.co.asoft.persist.repo.IRepo
import tz.co.asoft.persist.result.Result
import tz.co.asoft.persist.tools.Cause

class DeleteUserUseCase(
        private val auth: FirebaseAuth,
        private val loadUserUC: ILoadUserUseCase,
        private val repo: IRepo<User>
) : IDeleteUserUseCase {

    override suspend fun invoke(email: String, pwd: String) = Result.catching {
        auth.loginUserWithEmailAndPassword(email, pwd)
        auth.currentUser?.remove()
        if (repo is IAuthRepo) {
            val user = loadUserUC(email, pwd).respond()
            repo.delete(user)
        } else throw Cause("Can't delete user from a non IAuthRepo")
    }
}