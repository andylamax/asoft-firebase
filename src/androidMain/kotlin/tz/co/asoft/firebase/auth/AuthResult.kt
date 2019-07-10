package tz.co.asoft.firebase.auth

import com.google.firebase.auth.AuthResult as GAuthResult

actual typealias AuthResult = GAuthResult

actual val AuthResult.user get() = user