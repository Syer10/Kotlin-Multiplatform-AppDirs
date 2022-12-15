package ca.gosyer.appdirs.impl

import ca.gosyer.appdirs.AppDirs

internal expect fun getFromEnv(name: String): String?

internal fun getFromEnv(name: String, defaultValue: () -> String): String {
    return getFromEnv(name) ?: defaultValue()
}

class UnixAppDirs : AppDirs {
    override fun getUserDataDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?,
        roaming: Boolean
    ): String {
        val dir = getFromEnv(XDG_DATA_HOME) { buildPath(home(), "/.local/share") }
        return buildPath(dir, appName, appVersion)
    }

    override fun getUserConfigDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?,
        roaming: Boolean
    ): String {
        val dir = getFromEnv(XDG_CONFIG_HOME) { buildPath(home(), "/.config") }
        return buildPath(dir, appName, appVersion)
    }

    override fun getUserCacheDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?
    ): String {
        val dir = getFromEnv(XDG_CACHE_HOME) { buildPath(home(), "/.cache") }
        return buildPath(dir, appName, appVersion)
    }

    override fun getSiteDataDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?,
        multiPath: Boolean
    ): String {
        val xdgDirs = getFromEnv(XDG_DATA_DIRS)
        if (xdgDirs == null) {
            val primary: String = buildPath("/usr/local/share", appName, appVersion)
            val secondary: String = buildPath("/usr/share", appName, appVersion)
            return if (multiPath) joinPaths(primary, secondary) else primary
        }
        val xdgDirArr: Array<String> = splitPaths(xdgDirs)
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
        val xdgDirs = getFromEnv(XDG_CONFIG_DIRS)
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
        xdgDirArr: Array<String>
    ): String {
        return joinPaths(
            *xdgDirArr
                .map { buildPath(it, appName, appVersion) }
                .toTypedArray()
        )
    }

    override fun getUserLogDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?
    ): String {
        val dir = getFromEnv(XDG_CACHE_HOME) { buildPath(home(), "/.cache") }
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