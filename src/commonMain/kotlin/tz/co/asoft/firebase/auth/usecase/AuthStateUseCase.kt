package tz.co.asoft.firebase.auth.usecase

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import tz.co.asoft.auth.User
import tz.co.asoft.firebase.auth.repo.AuthFirebaseAbstractRepo
import tz.co.asoft.persist.tools.Singleton
import tz.co.asoft.rx.lifecycle.LifeCycle
import tz.co.asoft.rx.lifecycle.LiveData

class AuthStateUseCase private constructor(private val repo: AuthFirebaseAbstractRepo) : UpdateStatusUseCase(repo) {
    companion object : Singleton<AuthFirebaseAbstractRepo, AuthStateUseCase>({ AuthStateUseCase((it)) })

    val liveUser = LiveData<User?>(null)

    suspend fun onAuthStateChanged(lifeCycle: LifeCycle, onChange: (User?) -> Unit) = coroutineScope {
        if (liveUser.value == null) {
            launch { liveUser.value = repo.loadLocalUser() }
        }
        liveUser.observe(lifeCycle, onChange)
    }
}