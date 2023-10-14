package ca.gosyer.appdirs.impl

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.toKString
import platform.posix.getenv

@OptIn(ExperimentalForeignApi::class)
class LinuxEnvResolver : UnixEnvResolver {
    override fun get(name: String): String? = getenv(name)?.toKString()
}