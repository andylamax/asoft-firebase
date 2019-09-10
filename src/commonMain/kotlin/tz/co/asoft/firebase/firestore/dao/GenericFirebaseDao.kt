package tz.co.asoft.firebase.firestore.dao

import kotlinx.serialization.KSerializer
import tz.co.asoft.firebase.firestore.FirebaseFirestore
import tz.co.asoft.firebase.firestore.batch
import tz.co.asoft.firebase.firestore.batch.put
import tz.co.asoft.firebase.firestore.batch.submit
import tz.co.asoft.firebase.firestore.collection
import tz.co.asoft.firebase.firestore.collection.doc
import tz.co.asoft.firebase.firestore.document.id
import tz.co.asoft.firebase.firestore.query.fetch
import tz.co.asoft.firebase.firestore.snapshot.documents
import tz.co.asoft.firebase.firestore.snapshot.toObject
import tz.co.asoft.persist.dao.Dao
import tz.co.asoft.persist.model.Entity

class GenericFirebaseDao<T : Entity>(
    val firestore: FirebaseFirestore,
    val collectionName: String,
    val serializer: KSerializer<T>
) : Dao<T>() {

    open val batch get() = firestore.batch()

    val collection = firestore.collection(collectionName)

    fun docRef(id: String) = collection.doc(id)

    override suspend fun create(list: List<T>): List<T>? = batch.run {
        list.forEach {
            val doc = collection.doc()
            put(doc, it.apply { uid = doc.id }, serializer)
        }
        submit()
        list
    }

    override suspend fun edit(list: List<T>): List<T>? = batch.run {
        list.forEach { put(collection.doc(it.uid), it, serializer) }
        submit()
        list
    }

    override suspend fun delete(list: List<T>): List<T>? = batch.run {
        list.forEach { delete(docRef(it.uid)) }
        submit()
        return list
    }

    override suspend fun all(): List<T>? = collection.fetch().documents.mapNotNull { it.toObject(serializer) }
}