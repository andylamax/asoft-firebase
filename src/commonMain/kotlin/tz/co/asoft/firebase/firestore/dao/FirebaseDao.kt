package tz.co.asoft.firebase.firestore.dao

import kotlinx.serialization.KSerializer
import tz.co.asoft.firebase.firestore.FirebaseFirestore
import tz.co.asoft.persist.model.Entity

open class FirebaseDao<T : Entity>(
        override val firestore: FirebaseFirestore,
        override val collectionName: String,
        override val serializer: KSerializer<T>
) : IFirebaseDao<T>