package ca.gosyer.appdirs.impl

internal actual fun home() = System.getProperty("user.home")

internal actual fun fileSeparator() = System.getProperty("file.separator")

internal actual fun pathSeparator() = System.getProperty("path.separator")




