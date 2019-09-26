package tz.co.asoft.firebase.firestore.dao

import kotlinx.serialization.KSerializer
import tz.co.asoft.firebase.firestore.FirebaseFirestore
import tz.co.asoft.persist.model.Entity
import kotlin.reflect.KClass

object FirebaseDaoFactory {
    val daos = mutableMapOf<KClass<*>, FirebaseDao<*>>()

    inline fun <reified T : Entity> getDao(firestore: FirebaseFirestore, collectionName: String, serializer: KSerializer<T>): FirebaseDao<T> {
        return daos.getOrPut(T::class) { FirebaseDao(firestore, collectionName, serializer) } as FirebaseDao<T>
    }
}