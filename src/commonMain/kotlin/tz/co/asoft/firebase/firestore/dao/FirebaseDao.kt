package tz.co.asoft.firebase.firestore.dao

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.serialization.KSerializer
import tz.co.asoft.auth.User
import tz.co.asoft.firebase.firestore.FirebaseFirestore
import tz.co.asoft.firebase.firestore.batch
import tz.co.asoft.firebase.firestore.batch.put
import tz.co.asoft.firebase.firestore.batch.submit
import tz.co.asoft.firebase.firestore.collection
import tz.co.asoft.firebase.firestore.collection.addListener
import tz.co.asoft.firebase.firestore.collection.doc
import tz.co.asoft.firebase.firestore.document.addListener
import tz.co.asoft.firebase.firestore.document.fetch
import tz.co.asoft.firebase.firestore.document.id
import tz.co.asoft.firebase.firestore.query.fetch
import tz.co.asoft.firebase.firestore.query.where
import tz.co.asoft.firebase.firestore.snapshot.toObject
import tz.co.asoft.firebase.firestore.snapshot.toObjects
import tz.co.asoft.persist.dao.Dao
import tz.co.asoft.persist.model.Entity
import tz.co.asoft.persist.result.Result
import tz.co.asoft.rx.lifecycle.LifeCycle
import tz.co.asoft.rx.lifecycle.LiveData
import tz.co.asoft.rx.lifecycle.Observer

open class FirebaseDao<T : Entity>(
        open val firestore: FirebaseFirestore,
        open val collectionName: String,
        open val serializer: KSerializer<T>
) : Dao<T>() {

    open val batch get() = firestore.batch()

    val collection by lazy { firestore.collection(collectionName) }

    open fun docRef(id: String) = collection.doc(id)

    override suspend fun create(list: List<T>): List<T>? = batch.run {
        list.forEach {
            val doc = if (it.uid.isNotBlank()) collection.doc(it.uid) else collection.doc()
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

    override suspend fun load(ids: List<Any>): List<T>? = coroutineScope {
        val users = ids.map { async { docRef(it.toString()).fetch().toObject(serializer) } }
        users.mapNotNull { it.await() }
    }

    open fun live(t: T) = LiveData(t).apply {
        docRef(t.uid).addListener { doc -> doc.toObject(serializer)?.let { value = it } }
    }

    override suspend fun observeCatching(lifeCycle: LifeCycle, onChange: (Result<List<T>>) -> Unit) =
            getLiveData().map {
                Result(it)
            }.observe(lifeCycle, onChange)

    override suspend fun observeForeverCatching(onChange: (Result<List<T>>) -> Unit) = getLiveData().map {
        Result(it)
    }.observeForever(onChange)

    var isListening = false
    override suspend fun getLiveData(): LiveData<List<T>?> {
        if (!isListening) {
            isListening = true
            collection.addListener { liveData.value = it.toObjects(serializer) }
        }
        return liveData
    }

    override suspend fun all(): List<T>? = collection.fetch().toObjects(serializer)
}