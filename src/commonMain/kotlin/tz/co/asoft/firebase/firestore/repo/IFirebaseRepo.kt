package tz.co.asoft.firebase.firestore.repo

import tz.co.asoft.firebase.firestore.dao.IFirebaseDao
import tz.co.asoft.persist.model.Entity

interface IFirebaseRepo<T : Entity> : IFirebaseDao<T>