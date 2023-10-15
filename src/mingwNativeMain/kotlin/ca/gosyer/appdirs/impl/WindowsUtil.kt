package ca.gosyer.appdirs.impl

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.toKString
import platform.posix.getenv

@OptIn(ExperimentalForeignApi::class)
internal actual fun home(): String {
    memScoped {
        return getenv("USERPROFILE")!!.toKString()
    }
}

internal actual fun fileSeparator() : String = "\\"

internal actual fun pathSeparator() : String = ":"
