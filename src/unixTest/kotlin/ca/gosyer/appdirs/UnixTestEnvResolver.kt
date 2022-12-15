package ca.gosyer.appdirs

import ca.gosyer.appdirs.impl.UnixEnvResolver

class UnixTestEnvResolver(private val env: Map<String, String>) : UnixEnvResolver {
    override fun get(name: String): String? = env[name]
}