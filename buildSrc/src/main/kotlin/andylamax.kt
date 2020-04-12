fun asoftCore(lib: String, platform: String): String {
    return "com.github.andylamax.asoft-core:asoft-$lib-$platform:${versions.asoft.core}"
}

fun asoftBasics(lib: String, platform: String): String {
    return "com.github.andylamax.asoft-basics:asoft-$lib-$platform:${versions.asoft.basics}"
}

fun asoftPrimary(lib: String, platform: String): String {
    return "com.github.andylamax.asoft-primary:asoft-$lib-$platform:${versions.asoft.primary}"
}

fun asoftTest(platform: String) = asoftCore("test", platform)
