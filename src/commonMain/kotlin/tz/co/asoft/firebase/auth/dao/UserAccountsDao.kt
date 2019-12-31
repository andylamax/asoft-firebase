package tz.co.asoft.firebase.auth.dao

import tz.co.asoft.auth.UserAccount
import tz.co.asoft.firebase.firestore.FirebaseFirestore
import tz.co.asoft.firebase.firestore.dao.FirebaseDao

class UserAccountsDao(firestore: FirebaseFirestore) : FirebaseDao<UserAccount>(firestore, "user-accounts", UserAccount.serializer())