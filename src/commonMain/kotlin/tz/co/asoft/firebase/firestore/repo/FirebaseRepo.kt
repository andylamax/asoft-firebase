package tz.co.asoft.firebase.firestore.repo

import tz.co.asoft.firebase.firestore.dao.FirebaseDao
import tz.co.asoft.persist.model.Entity
import tz.co.asoft.persist.repo.Repo

open class FirebaseRepo<T : Entity>(private val dao: FirebaseDao<T>) : Repo<T>(dao) {
    open fun live(t: T) = dao.live(t)
}