package ca.gosyer.appdirs.impl

import ca.gosyer.appdirs.AppDirs
import ca.gosyer.appdirs.AppDirsConfig

class MacOSXAppDirs(
    private val config: AppDirsConfig
) : AppDirs {
    private val extras = config.extras

    override fun getUserDataDir(
        roaming: Boolean
    ): String {
        return buildPath(
            home(),
            "/Library/Application Support",
            *getAppName(),
            *extras
        )
    }

    override fun getUserConfigDir(
        roaming: Boolean
    ): String {
        return buildPath(home(), "/Library/Preferences", *getAppName(), *extras)
    }

    override fun getUserCacheDir(): String {
        return buildPath(home(), "/Library/Caches", *getAppName(), *extras)
    }

    override fun getSiteDataDir(
        multiPath: Boolean
    ): String {
        return buildPath("/Library/Application Support", *getAppName(), *extras)
    }

    override fun getSiteConfigDir(
        multiPath: Boolean
    ): String {
        return if (config.macOS.useLegacyConfigDir) {
            buildPath("/Library/Preferences", *getAppName(), *extras)
        } else {
            buildPath("/Library/Application Support/config", *getAppName(), *extras)
        }
    }

    override fun getUserLogDir(): String {
        return buildPath(home(), "/Library/Logs", *getAppName(), *extras)
    }

    override fun getSharedDir(): String {
        return buildPath(
            "/Users/Shared/Library/Application Support",
            *getAppName(),
            *extras
        )
    }

    private fun getAppName(): Array<String?> {
        if (
            config.macOS.useSpaceBetweenAuthorAndApp &&
            config.appAuthor != null &&
            config.appName != null
        ) {
            return arrayOf("${config.appAuthor} ${config.appName}")
        }
        return arrayOf(config.appAuthor, config.appName)
    }
}