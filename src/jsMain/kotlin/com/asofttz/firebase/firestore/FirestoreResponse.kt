package com.asofttz.firebase.firestore

import kotlinx.coroutines.await
import kotlin.js.Promise

actual class FirestoreResponse : Promise<QuerySnapshot>({ _, _ -> })

actual suspend fun FirestoreResponse.await(): QuerySnapshot = (this as Promise<QuerySnapshot>).await()