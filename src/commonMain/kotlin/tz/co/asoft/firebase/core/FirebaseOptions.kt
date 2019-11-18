package tz.co.asoft.firebase.core

expect class FirebaseOptions

expect var FirebaseOptions.apiKey: String
expect var FirebaseOptions.authDomain: String
expect var FirebaseOptions.databaseUrl: String?
expect var FirebaseOptions.projectId: String?
expect var FirebaseOptions.storageBucket: String?
expect var FirebaseOptions.messagingSenderId: String?
expect var FirebaseOptions.appId: String

expect class FirebaseOptionsBuilder()

expect var FirebaseOptionsBuilder.apiKey: String
expect var FirebaseOptionsBuilder.authDomain: String
expect var FirebaseOptionsBuilder.databaseUrl: String
expect var FirebaseOptionsBuilder.projectId: String
expect var FirebaseOptionsBuilder.storageBucket: String
expect var FirebaseOptionsBuilder.messagingSenderId: String
expect var FirebaseOptionsBuilder.appId: String
expect fun FirebaseOptionsBuilder.build(): FirebaseOptions