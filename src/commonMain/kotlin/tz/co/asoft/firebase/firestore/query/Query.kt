@file:JvmName("CommonQuery")

package tz.co.asoft.firebase.firestore.query

import tz.co.asoft.firebase.firestore.snapshot.QuerySnapshot
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

expect open class Query

expect fun Query.where(fieldPath: String, operator: String, value: Any): Query

expect fun Query.limit(limit: Long): Query

@Deprecated("Use fetch")
expect suspend fun Query.get(then: suspend (QuerySnapshot) -> Unit)

expect suspend fun Query.fetch(): QuerySnapshot

fun Query.where(qp: QueryParam): Query {
    val op = when (qp.op) {
        QueryParam.Operator.LessThan -> "<"
        QueryParam.Operator.LessThanOrEqual -> "<="
        QueryParam.Operator.Equals -> "=="
        QueryParam.Operator.GreaterThanOrEqual -> ">="
        QueryParam.Operator.GreaterThan -> ">"
        QueryParam.Operator.ArrayContains -> "array-contains"
    }
    return where(qp.left, op, qp.right)
}