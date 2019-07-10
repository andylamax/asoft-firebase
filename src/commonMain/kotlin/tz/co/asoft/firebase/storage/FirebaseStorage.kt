package tz.co.asoft.firebase.storage

import tz.co.asoft.firebase.core.FirebaseApp

expect class FirebaseStorage

expect val FirebaseStorage.app: FirebaseApp
expect fun FirebaseStorage.ref(path: String? = null): StorageReference

expect fun FirebaseApp.storage() : FirebaseStorage