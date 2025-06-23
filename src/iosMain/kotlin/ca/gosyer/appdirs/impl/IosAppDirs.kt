package ca.gosyer.appdirs.impl

import ca.gosyer.appdirs.AppDirs
import ca.gosyer.appdirs.AppDirsConfig
import ca.gosyer.appdirs.impl.pathSeparator

class IosAppDirs(
    appDirsConfig: AppDirsConfig,
): AppDirs {
    private val extras = appDirsConfig.extras.joinToString(pathSeparator())

    override fun getUserDataDir(roaming: Boolean): String {
        return TODO()
    }

    override fun getUserCacheDir(): String {
        return TODO()
    }

    override fun getUserConfigDir(roaming: Boolean): String {
        return TODO()
    }

    override fun getUserLogDir(): String {
        return TODO()
    }

    override fun getSiteDataDir(multiPath: Boolean): String {
        return TODO()
    }

    override fun getSiteConfigDir(multiPath: Boolean): String {
        return TODO()
    }

    override fun getSharedDir(): String {
        return TODO()
    }
}