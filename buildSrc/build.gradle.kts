plugins {
    id("org.gradle.kotlin.kotlin-dsl") version "1.3.5"
}

repositories {
    google()
    jcenter()
    maven(url = "https://dl.bintray.com/kotlin/kotlin-eap")
}

object versions {
    val kotlin = "1.4-M1"

    object android {
        const val build_tools = "3.6.0"
    }
}

dependencies {
    api("com.android.tools.build:gradle:${versions.android.build_tools}")
    api("org.jetbrains.kotlin:kotlin-gradle-plugin:${versions.kotlin}")
}