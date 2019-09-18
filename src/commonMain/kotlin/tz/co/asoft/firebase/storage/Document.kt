package tz.co.asoft.firebase.storage

import com.soywiz.klock.DateTime
import kotlinx.serialization.Serializable
import tz.co.asoft.auth.UserRef
import tz.co.asoft.neo4j.Neo4JEntity

@Serializable
open class Document : Neo4JEntity {
    override var id: Long? = null
    override var uid = ""
    open var name = ""
    open var url = ""
    open var uploader = UserRef()
    open var uploaded = DateTime.nowUnixLong()
    open var permits = mutableSetOf<String>()
}