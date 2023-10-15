package ca.gosyer.appdirs.impl

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.pointed
import kotlinx.cinterop.toKString
import platform.posix.getenv
import platform.posix.getpwuid
import platform.posix.getuid

@OptIn(ExperimentalForeignApi::class)
internal actual fun home(): String {
    memScoped {
        val home = getenv("HOME")
        if (home != null) {
            return home.toKString()
        } else {
            val uid = getuid()
            return getpwuid(uid)?.pointed?.pw_dir!!.toKString()
        }
    }
}

internal actual fun fileSeparator() : String = "/"

internal actual fun pathSeparator() : String = ":"