package tz.co.asoft.firebase.firestore.query

import tz.co.asoft.firebase.firestore.query.QueryParam.Operator

class QueryParam(val left: String, val op: Operator, val right: Any) {
    enum class Operator {
        LessThan,
        LessThanOrEqual,
        Equals,
        GreaterThanOrEqual,
        GreaterThan,
        ArrayContains
    }
}

infix fun String.isLessThan(other: String) = QueryParam(this, Operator.LessThan, other)

infix fun String.isLessThan(other: Number) = QueryParam(this, Operator.LessThan, other)

infix fun String.isLessThanOrEqualTo(other: String) = QueryParam(this, Operator.LessThanOrEqual, other)

infix fun String.isLessThanOrEqualTo(other: Number) = QueryParam(this, Operator.LessThanOrEqual, other)

infix fun String.equals(other: String) = QueryParam(this, Operator.Equals, other)

infix fun String.equals(other: Number) = QueryParam(this, Operator.Equals, other)

infix fun String.isGreaterThanOrEqualTo(other: String) = QueryParam(this, Operator.GreaterThanOrEqual, other)

infix fun String.isGreaterThanOrEqualTo(other: Number) = QueryParam(this, Operator.GreaterThanOrEqual, other)

infix fun String.isGreaterThan(other: String) = QueryParam(this, Operator.GreaterThan, other)

infix fun String.isGreaterThan(other: Number) = QueryParam(this, Operator.GreaterThan, other)

infix fun String.arrayContains(other: String) = QueryParam(this, Operator.ArrayContains, other)

infix fun String.arrayContains(other: Number) = QueryParam(this, Operator.ArrayContains, other)
