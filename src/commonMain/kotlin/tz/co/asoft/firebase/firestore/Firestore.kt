package tz.co.asoft.firebase.firestore

import tz.co.asoft.firebase.core.FirebaseApp
import tz.co.asoft.firebase.firestore.collection.CollectionReference
import tz.co.asoft.firebase.firestore.document.DocumentReference

expect class FirebaseFirestore

expect val FirebaseFirestore.app : FirebaseApp

expect fun FirebaseFirestore.collection(path: String): CollectionReference

expect fun FirebaseFirestore.document(path: String): DocumentReference

expect fun FirebaseApp.firestore() : FirebaseFirestore