package tz.co.asoft.firebase.firestore.dao

import kotlinx.serialization.KSerializer
import tz.co.asoft.firebase.firestore.FirebaseFirestore
import tz.co.asoft.persist.dao.DaoFactory
import tz.co.asoft.persist.model.Entity
import kotlin.reflect.KClass

@Deprecated("Use dao builders")
object FirebaseDaoFactory {
    inline fun <reified T : Entity> getDao(firestore: FirebaseFirestore, collectionName: String, serializer: KSerializer<T>): FirebaseDao<T> {
        return DaoFactory.getDao { FirebaseDao(firestore, collectionName, serializer) }
    }
}