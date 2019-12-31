package tz.co.asoft.firebase.auth.dao

import tz.co.asoft.auth.Role
import tz.co.asoft.firebase.firestore.FirebaseFirestore
import tz.co.asoft.firebase.firestore.dao.FirebaseDao

class RolesDao(firestore: FirebaseFirestore) : FirebaseDao<Role>(firestore, "roles", Role.serializer())