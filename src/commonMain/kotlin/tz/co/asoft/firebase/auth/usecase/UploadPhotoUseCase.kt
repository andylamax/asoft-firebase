package tz.co.asoft.firebase.auth.usecase

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import tz.co.asoft.auth.User
import tz.co.asoft.firebase.auth.repo.AuthFirebaseAbstractRepo
import tz.co.asoft.io.file.File
import tz.co.asoft.persist.result.Result
import tz.co.asoft.persist.tools.Cause

class UploadPhotoUseCase(val repo: AuthFirebaseAbstractRepo, private val authStateUC: AuthStateUseCase) {
    suspend operator fun invoke(u: User, file: File) = coroutineScope {
        Result.catching {
            val user = repo.uploadPhoto(u, file) ?: throw Cause("Failed To Upload Photo")
            authStateUC.liveUser.value = user
            launch {
                repo.saveToLocal(user)
                repo.edit(user)
            }
            user
        }
    }
}