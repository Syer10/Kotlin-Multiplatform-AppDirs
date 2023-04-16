package ca.gosyer.appdirs.impl

import ca.gosyer.appdirs.AppDirs

class UnixAppDirs(
    private val appName: String?,
    private val appAuthor: String? = null,
    vararg extra: String,
    private val envResolver: UnixEnvResolver
) : AppDirs {
    private val extras = extra

    override fun getUserDataDir(
        roaming: Boolean
    ): String {
        val dir = envResolver.getOrDefault(XDG_DATA_HOME) { buildPath(home(), "/.local/share") }
        return buildPath(dir, appName, *extras)
    }

    override fun getUserConfigDir(
        roaming: Boolean
    ): String {
        val dir = envResolver.getOrDefault(XDG_CONFIG_HOME) { buildPath(home(), "/.config") }
        return buildPath(dir, appName, *extras)
    }

    override fun getUserCacheDir(): String {
        val dir = envResolver.getOrDefault(XDG_CACHE_HOME) { buildPath(home(), "/.cache") }
        return buildPath(dir, appName, *extras)
    }

    override fun getSiteDataDir(
        multiPath: Boolean
    ): String {
        val xdgDirs = envResolver[XDG_DATA_DIRS]
        if (xdgDirs == null) {
            val primary = buildPath("/usr/local/share", appName, *extras)
            val secondary = buildPath("/usr/share", appName, *extras)
            return if (multiPath) joinPaths(listOf(primary, secondary)) else primary
        }
        val xdgDirArr = splitPaths(xdgDirs)
        return if (multiPath) {
            buildMultiPaths(appName, extras, xdgDirArr)
        } else {
            buildPath(xdgDirArr[0], appName, *extras)
        }
    }

    override fun getSiteConfigDir(
        multiPath: Boolean
    ): String {
        val xdgDirs = envResolver[XDG_CONFIG_DIRS]
            ?: return buildPath("/etc/xdg", appName, *extras)
        val xdgDirArr = splitPaths(xdgDirs)
        return if (multiPath) {
            buildMultiPaths(appName, extras, xdgDirArr)
        } else {
            buildPath(xdgDirArr[0], appName, *extras)
        }
    }

    private fun buildMultiPaths(
        appName: String?,
        extra: Array<out String>,
        xdgDirArr: List<String>
    ): String {
        return joinPaths(
            xdgDirArr.map { buildPath(it, appName, *extra) }
        )
    }

    override fun getUserLogDir(): String {
        val dir = envResolver.getOrDefault(XDG_CACHE_HOME) { buildPath(home(), "/.cache") }
        return buildPath(dir, appName, "/logs", *extras)
    }

    override fun getSharedDir(): String {
        return buildPath("/srv", appName, *extras)
    }

    companion object {
        const val XDG_CONFIG_DIRS = "XDG_CONFIG_DIRS"
        const val XDG_DATA_DIRS = "XDG_DATA_DIRS"
        const val XDG_CACHE_HOME = "XDG_CACHE_HOME"
        const val XDG_CONFIG_HOME = "XDG_CONFIG_HOME"
        const val XDG_DATA_HOME = "XDG_DATA_HOME"
    }
}