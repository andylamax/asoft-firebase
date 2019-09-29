package tz.co.asoft.firebase.firestore.viewmodel

import tz.co.asoft.firebase.firestore.repo.IFirebaseRepo
import tz.co.asoft.persist.model.Entity
import tz.co.asoft.persist.viewmodel.ViewModel

interface FirebaseViewModel<T : Entity> : IFirebaseRepo<T>