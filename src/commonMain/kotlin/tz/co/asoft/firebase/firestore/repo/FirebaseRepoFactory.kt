package tz.co.asoft.firebase.firestore.repo

import tz.co.asoft.firebase.firestore.dao.FirebaseDao
import tz.co.asoft.persist.model.Entity
import tz.co.asoft.persist.repo.Repo
import kotlin.reflect.KClass

object FirebaseRepoFactory {
    val repos = mutableMapOf<KClass<*>, FirebaseRepo<*>>()

    inline fun <reified T : Entity> getRepo(dao: FirebaseDao<T>): FirebaseRepo<T> {
        return repos.getOrPut(T::class) { FirebaseRepo(dao) } as FirebaseRepo<T>
    }
}