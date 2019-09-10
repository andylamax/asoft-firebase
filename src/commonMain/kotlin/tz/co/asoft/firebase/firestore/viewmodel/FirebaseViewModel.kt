package tz.co.asoft.firebase.firestore.viewmodel

import tz.co.asoft.firebase.firestore.repo.FirebaseRepo
import tz.co.asoft.persist.model.Entity
import tz.co.asoft.persist.viewmodel.ViewModel

open class FirebaseViewModel<T : Entity>(private val repo: FirebaseRepo<T>) : ViewModel<T>(repo) {
    open fun live(t: T) = repo.live(t)
}