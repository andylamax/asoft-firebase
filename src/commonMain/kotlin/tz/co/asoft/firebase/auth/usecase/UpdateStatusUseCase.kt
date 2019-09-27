package tz.co.asoft.firebase.auth.usecase

import com.soywiz.klock.DateTime
import tz.co.asoft.auth.User
import tz.co.asoft.firebase.auth.repo.AuthFirebaseAbstractRepo
import tz.co.asoft.persist.result.Result

open class UpdateStatusUseCase(private val repo: AuthFirebaseAbstractRepo) {
    suspend operator fun invoke(u: User, s: User.Status) = Result.catching {
        u.lastSeen = DateTime.nowUnixLong()
        u.status = s.name
        repo.edit(u)
    }
}