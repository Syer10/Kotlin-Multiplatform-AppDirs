package ca.gosyer.appdirs.impl

internal actual fun home(): String {
    return System.getProperty("user.home")
}

internal actual fun fileSeparator() = System.getProperty("file.separator")

internal actual fun pathSeparator() = System.getProperty("path.separator")

internal actual fun getFromEnv(name: String): String? {
    return System.getenv(name)
}


