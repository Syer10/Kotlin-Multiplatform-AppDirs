package ca.gosyer.appdirs.impl

interface UnixEnvResolver {
    operator fun get(name: String): String?

    fun getOrDefault(name: String, defaultValue: () -> String): String {
        return get(name) ?: defaultValue()
    }
}