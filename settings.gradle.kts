pluginManagement {
    repositories {
        google()
        jcenter()
        maven(url = "https://jitpack.io")
        maven(url = "https://dl.bintray.com/kotlin/kotlin-eap")
    }

    val versions = object {
        val kotlin = "1.4-M1"
        val android_tools = "3.6.0"
    }

    resolutionStrategy {
        eachPlugin {
            if (requested.id.id.contains("kotlin.multiplatform")) {
                useModule("org.jetbrains.kotlin:kotlin-gradle-plugin:${versions.kotlin}")
            }
            if (requested.id.id.contains("serialization")) {
                useModule("org.jetbrains.kotlin:kotlin-serialization:${versions.kotlin}")
            }
            if (requested.id.id.contains("android")) {
                useModule("com.android.tools.build:gradle:${versions.android_tools}")
            }
        }
    }
}

rootProject.name = "asoft-firebase"