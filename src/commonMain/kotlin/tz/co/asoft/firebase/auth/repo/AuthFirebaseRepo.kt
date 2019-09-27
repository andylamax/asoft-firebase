package tz.co.asoft.firebase.auth.repo

import tz.co.asoft.auth.dao.AuthAbstractLocalDao
import tz.co.asoft.auth.repo.AuthAbstractRepo
import tz.co.asoft.firebase.auth.dao.AuthFirebaseAbstractDao

class AuthFirebaseRepo private constructor(dao: AuthFirebaseAbstractDao, localDao: AuthAbstractLocalDao) :
        AuthFirebaseAbstractRepo(dao, localDao) {

    companion object {
        private var instance: AuthFirebaseAbstractRepo? = null
        fun getInstance(dao: AuthFirebaseAbstractDao, localDao: AuthAbstractLocalDao) =
                instance ?: AuthFirebaseRepo(dao, localDao).also {
                    instance = it
                }
    }
}