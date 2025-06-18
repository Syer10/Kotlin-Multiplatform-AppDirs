package ca.gosyer.appdirs.impl

import node.process.process

class UnixJvmEnvResolver : UnixEnvResolver {
    override fun get(name: String): String? = process.env[name].unsafeCast<String?>()
}