package tz.co.asoft.firebase.firestore.dao

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.serialization.KSerializer
import tz.co.asoft.firebase.firestore.FirebaseFirestore
import tz.co.asoft.firebase.firestore.batch
import tz.co.asoft.firebase.firestore.batch.put
import tz.co.asoft.firebase.firestore.batch.submit
import tz.co.asoft.firebase.firestore.collection
import tz.co.asoft.firebase.firestore.collection.doc
import tz.co.asoft.firebase.firestore.document.fetch
import tz.co.asoft.firebase.firestore.document.id
import tz.co.asoft.firebase.firestore.query.fetch
import tz.co.asoft.firebase.firestore.snapshot.toObject
import tz.co.asoft.firebase.firestore.snapshot.toObjects
import tz.co.asoft.persist.dao.IDao
import tz.co.asoft.persist.model.Entity

interface IFirebaseDao<T : Entity> : IDao<T> {

    val firestore: FirebaseFirestore

    val serializer: KSerializer<T>

    val collectionName: String

    val batch get() = firestore.batch()

    val collection get() = firestore.collection(collectionName)

    fun docRef(id: String) = collection.doc(id)

    override suspend fun create(list: List<T>): List<T> = batch.run {
        list.forEach {
            val doc = if (it.uid.isNotBlank()) collection.doc(it.uid) else collection.doc()
            put(doc, it.apply { uid = doc.id }, serializer)
        }
        submit()
        list
    }

    override suspend fun create(t: T): T = create(listOf(t)).first()

    override suspend fun edit(list: List<T>): List<T> = batch.run {
        list.forEach { put(collection.doc(it.uid), it, serializer) }
        submit()
        list
    }

    override suspend fun edit(t: T): T = edit(listOf(t)).first()

    override suspend fun wipe(list: List<T>): List<T> = batch.run {
        list.forEach { delete(docRef(it.uid)) }
        submit()
        return list
    }

    override suspend fun delete(t: T) = wipe(t)

    override suspend fun wipe(t: T): T = wipe(listOf(t)).first()

    override suspend fun load(ids: List<Any>): List<T> = coroutineScope {
        val users = ids.map { async { docRef(it.toString()).fetch().toObject(serializer) } }
        users.mapNotNull { it.await() }
    }

    override suspend fun load(id: String): T? = load(listOf(id)).firstOrNull()

    override suspend fun all(): List<T> = collection.fetch().toObjects(serializer)
}