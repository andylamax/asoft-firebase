package tz.co.asoft.firebase.firestore.viewmodel

import tz.co.asoft.firebase.firestore.repo.IFirebaseRepo
import tz.co.asoft.persist.model.Entity
import tz.co.asoft.persist.viewmodel.ViewModel

@Deprecated("Create a view model for a specific view")
interface FirebaseViewModel<T : Entity> : IFirebaseRepo<T>