package ca.gosyer.appdirs.impl

class UnixJvmEnvResolver : UnixEnvResolver {
    override fun get(name: String): String? = System.getenv(name)
}