package ca.gosyer.appdirs.impl

import node.process.process

class UnixJsEnvResolver : UnixEnvResolver {
    override fun get(name: String): String? = process.env[name].unsafeCast<String?>()
}