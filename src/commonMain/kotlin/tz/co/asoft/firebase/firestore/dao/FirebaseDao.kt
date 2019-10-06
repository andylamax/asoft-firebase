package tz.co.asoft.firebase.firestore.dao

import kotlinx.serialization.KSerializer
import tz.co.asoft.firebase.firestore.FirebaseFirestore
import tz.co.asoft.firebase.firestore.batch
import tz.co.asoft.firebase.firestore.collection
import tz.co.asoft.persist.model.Entity
import tz.co.asoft.rx.lifecycle.LiveData

open class FirebaseDao<T : Entity>(
        override val firestore: FirebaseFirestore,
        override val collectionName: String,
        override val serializer: KSerializer<T>
) : IFirebaseDao<T> {
    override val liveData = LiveData<List<T>?>(null)

    override var isListening = false
}