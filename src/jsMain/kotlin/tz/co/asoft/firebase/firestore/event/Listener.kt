package tz.co.asoft.firebase.firestore.event

class Listener<T>(val next: (T) -> Unit, val error: (Any) -> Unit)