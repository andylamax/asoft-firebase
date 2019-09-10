package tz.co.asoft.firebase.firestore.entity

import tz.co.asoft.persist.model.Entity
import tz.co.asoft.rx.lifecycle.LiveData

fun <T : Entity> T.liveData() = LiveData(this).apply {

}