package ca.gosyer.appdirs.impl

import ca.gosyer.appdirs.AppDirs

class UnixAppDirs(private val envResolver: UnixEnvResolver) : AppDirs {
    override fun getUserDataDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?,
        roaming: Boolean
    ): String {
        val dir = envResolver.getOrDefault(XDG_DATA_HOME) { buildPath(home(), "/.local/share") }
        return buildPath(dir, appName, appVersion)
    }

    override fun getUserConfigDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?,
        roaming: Boolean
    ): String {
        val dir = envResolver.getOrDefault(XDG_CONFIG_HOME) { buildPath(home(), "/.config") }
        return buildPath(dir, appName, appVersion)
    }

    override fun getUserCacheDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?
    ): String {
        val dir = envResolver.getOrDefault(XDG_CACHE_HOME) { buildPath(home(), "/.cache") }
        return buildPath(dir, appName, appVersion)
    }

    override fun getSiteDataDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?,
        multiPath: Boolean
    ): String {
        val xdgDirs = envResolver[XDG_DATA_DIRS]
        if (xdgDirs == null) {
            val primary = buildPath("/usr/local/share", appName, appVersion)
            val secondary = buildPath("/usr/share", appName, appVersion)
            return if (multiPath) joinPaths(listOf(primary, secondary)) else primary
        }
        val xdgDirArr = splitPaths(xdgDirs)
        return if (multiPath) {
            buildMultiPaths(appName, appVersion, xdgDirArr)
        } else {
            buildPath(xdgDirArr[0], appName, appVersion)
        }
    }

    override fun getSiteConfigDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?,
        multiPath: Boolean
    ): String {
        val xdgDirs = envResolver[XDG_CONFIG_DIRS]
            ?: return buildPath("/etc/xdg", appName, appVersion)
        val xdgDirArr = splitPaths(xdgDirs)
        return if (multiPath) {
            buildMultiPaths(appName, appVersion, xdgDirArr)
        } else {
            buildPath(xdgDirArr[0], appName, appVersion)
        }
    }

    private fun buildMultiPaths(
        appName: String?,
        appVersion: String?,
        xdgDirArr: List<String>
    ): String {
        return joinPaths(
            xdgDirArr.map { buildPath(it, appName, appVersion) }
        )
    }

    override fun getUserLogDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?
    ): String {
        val dir = envResolver.getOrDefault(XDG_CACHE_HOME) { buildPath(home(), "/.cache") }
        return buildPath(dir, appName, "/logs", appVersion)
    }

    override fun getSharedDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?
    ): String {
        return buildPath("/srv", appName, appVersion)
    }

    companion object {
        const val XDG_CONFIG_DIRS = "XDG_CONFIG_DIRS"
        const val XDG_DATA_DIRS = "XDG_DATA_DIRS"
        const val XDG_CACHE_HOME = "XDG_CACHE_HOME"
        const val XDG_CONFIG_HOME = "XDG_CONFIG_HOME"
        const val XDG_DATA_HOME = "XDG_DATA_HOME"
    }
}