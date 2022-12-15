package ca.gosyer.appdirs.impl

import kotlinx.cinterop.toKString
import platform.posix.getenv

class LinuxEnvResolver : UnixEnvResolver {
    override fun get(name: String): String? = getenv(name)?.toKString()
}