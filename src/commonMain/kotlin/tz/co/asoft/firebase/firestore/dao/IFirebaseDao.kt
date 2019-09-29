package tz.co.asoft.firebase.firestore.dao

import tz.co.asoft.persist.model.Entity
import tz.co.asoft.rx.lifecycle.LiveData

interface IFirebaseDao<T : Entity> {
    fun live(t: T): LiveData<T>
}