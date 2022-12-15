package ca.gosyer.appdirs.impl

import kotlinx.cinterop.memScoped
import kotlinx.cinterop.pointed
import kotlinx.cinterop.toKString
import platform.posix.getenv

internal actual fun home(): String {
    memScoped {
        return getenv("USERPROFILE")!!.toKString()
    }
}

internal actual fun fileSeparator() : String = "\\"

internal actual fun pathSeparator() : String = ":"
