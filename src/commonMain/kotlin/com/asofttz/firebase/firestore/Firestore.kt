package com.asofttz.firebase.firestore

import com.asofttz.firebase.core.FirebaseApp
import com.asofttz.firebase.firestore.collection.CollectionReference
import com.asofttz.firebase.firestore.document.DocumentReference

expect class FirebaseFirestore {

}

expect val FirebaseFirestore.app : FirebaseApp

expect fun FirebaseFirestore.collection(path: String): CollectionReference

expect fun FirebaseFirestore.document(path: String): DocumentReference

expect fun FirebaseApp.firestore() : FirebaseFirestore